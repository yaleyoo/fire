package com.fes.common.service;

import com.fes.common.constants.MailConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
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
        try {
            session = Session.getDefaultInstance(props, null);
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
            transport.sendMessage(msg, msg.getAllRecipients());
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