package com.fes.common.service;

import com.fes.common.constants.MailConstants;
import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Properties;


/**
 * Created by yuanqi on 16/1/8.
 * 邮件发送服务
 */
public class MailSendService {
    private static final Logger log = LoggerFactory.getLogger(MailSendService.class);
    @Resource
    private MailConstants mailConstants;
    private Properties props = new Properties();
    private Transport transport;
    private Session session;

    public void init() {
        log.info("初始化邮件参数");
        props.put("mail.smtp.host", mailConstants.getSendSmtp());
        props.put("mail.smtp.port", mailConstants.getSendPort());
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        // props.setProperty("mail.smtp.port", "465");
        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);


            session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    PasswordAuthentication pa = new PasswordAuthentication(mailConstants.getSendMail(),mailConstants.getSendPassword());
                    return pa;
                }
            });
            transport = session.getTransport("smtp");
            transport.connect(mailConstants.getSendSmtp(), mailConstants.getSendMail(), mailConstants.getSendPassword());
            log.info("host {} port {} user {} password {}", mailConstants.getSendSmtp(), mailConstants.getSendPort(),
                    mailConstants.getSendMail(), mailConstants.getSendPassword());
        } catch (Exception e) {
            log.error("occurs exception!", e);
        }
    }



    public void close() {
        try {
            if (transport.isConnected()) {
                transport.close();
            }
        } catch (Exception ex) {
            log.error("occurs exception", ex);
        } finally {
            try {
                transport.close();
            } catch (Exception ex) {
                log.error("close occurs exception", ex);
            }
        }
    }


    public void sendMail(String toEmail, String subject, String content) throws Exception {

        try {
            init();

            //发送的邮件地址
            InternetAddress fromAddress;
            InternetAddress[] toAddress = new InternetAddress[1];
            //创建消息
            MimeMessage msg = new MimeMessage(session);
            //设置发送日期
            msg.setSentDate(new Date());
            msg.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(mailConstants.getSendMail()));
            MimeMessageHelper helper = new MimeMessageHelper(msg,true,"utf-8");
            fromAddress = new InternetAddress(mailConstants.getSendMail(), subject, "UTF-8");
            msg.setFrom(fromAddress);
            toAddress[0] = new InternetAddress(toEmail);
            msg.setRecipients(Message.RecipientType.TO, toAddress);
            //标题
            msg.setSubject(subject, "UTF-8");
            //文本体
            msg.setContent(content, "text/html;charset=utf-8");
            msg.saveChanges();
            //发送
            transport.send(msg);
        } finally {
            close();
        }
    }

    public void sendMail(List<String> toEmail, String subject, String content) throws Exception {
        //验证email
        if (CollectionUtils.isEmpty(toEmail)) {
            log.info("邮件列表为空！");
            return;
        }

        try {
            init();

            //发送的邮件地址
            InternetAddress fromAddress;
            InternetAddress[] toAddress = new InternetAddress[toEmail.size()];
            //创建消息
            MimeMessage msg = new MimeMessage(session);
            //设置发送日期
            msg.setSentDate(new Date());
            fromAddress = new InternetAddress(mailConstants.getSendMail(), subject, "UTF-8");
            msg.setFrom(fromAddress);
            for (int i = 0; i < toAddress.length; i++) {
                toAddress[i] = new InternetAddress(toEmail.get(i));
            }
            msg.setRecipients(Message.RecipientType.TO, toAddress);
            //标题
            msg.setSubject(subject, "UTF-8");
            //文本体
            msg.setContent(content, "text/html;charset=utf-8");
            msg.saveChanges();
            //发送
            transport.sendMessage(msg, msg.getAllRecipients());
        } finally {
            close();
        }
    }
}