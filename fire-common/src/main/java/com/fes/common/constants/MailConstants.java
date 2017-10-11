package com.fes.common.constants;

/**
 * Created by yq on 2016/12/9.
 * 邮件发送常量
 */
public class MailConstants {

    private String sendSmtp;
    private String sendMail;
    private String sendPassword;
    private String sendPort;

    public static String SUBJECT = "FES Verify Code";



    public static String generateMailContent(String code){
        return "Dear Customer,<br>Here is your verify code: <b>"+code+"</b><br>This code will be expired in 30 minutes, " +
                "please use it to finish register as soon as possible!<br>Sincerely<br>FES team";
    }

    public String getSendSmtp() {
        return sendSmtp;
    }

    public void setSendSmtp(String sendSmtp) {
        this.sendSmtp = sendSmtp;
    }

    public String getSendMail() {
        return sendMail;
    }

    public void setSendMail(String sendMail) {
        this.sendMail = sendMail;
    }

    public String getSendPassword() {
        return sendPassword;
    }

    public void setSendPassword(String sendPassword) {
        this.sendPassword = sendPassword;
    }

    public String getSendPort() {
        return sendPort;
    }

    public void setSendPort(String sendPort) {
        this.sendPort = sendPort;
    }

}
