package com.jfone.mall.base.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public  class MailUtils {
	private static String smtp_host = "smtp.163.com";//网易stmp服务
	private static String username = "13413626893@163.com";//邮箱账户
	private static String password = "5201314b";//邮箱授权码密码
	private static String from = "13413626893@163.com";

	public static void sendMail(String subject, String content, String to) {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", smtp_host);
		props.setProperty("mail.transport.protocol", "smtp");
		/*props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");*/
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "false");
		Session session = Session.getInstance(props);
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setContent(content, "text/html;charset=utf-8");
			Transport transport = session.getTransport();
			transport.connect(smtp_host, username, password);
			transport.sendMessage(message, message.getAllRecipients());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("邮件发送失败...");
		}
	}

	public static void main(String[] args) {
		MailUtils.sendMail("注册会员","金丰一号商城提醒你:<br/>本次你注册的会员激活码为:," +
				"有效时间为5分钟，请及时激活，谢谢。<br/>" +
				"有任务问题请拨打4008008820。","13413626893@163.com");
	}
}
