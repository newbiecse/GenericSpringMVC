package com.learnspring.generic.comon;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class MailMail {
	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;
	private SimpleMailMessage simpleMailMessage;
	
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}	

	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String dear, String content) {

		MimeMessage message = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(new InternetAddress("newbiecse@gmail.com"));//(simpleMailMessage.getFrom());
			helper.setTo(new InternetAddress("newbiecse@gmail.com"));//(simpleMailMessage.getTo());
			helper.setSubject("test subject");//(simpleMailMessage.getSubject());
			helper.setText("content");//(String.format(simpleMailMessage.getText(), dear,content));

			Map model = new HashMap();
            model.put("user", "Tan");
			
			String text = VelocityEngineUtils.mergeTemplateIntoString(
                    velocityEngine, "com/learnspring/generic/template/templateEmail.vm", model);
//			String text = VelocityEngineUtils.mergeTemplateIntoString(
//                    velocityEngine, "webapp/WEB-INF/template/templateEmail.vm", model);
			
            
			helper.setText(text, true);			
			
//			FileSystemResource file = new FileSystemResource("C:\\log.txt");
//			helper.addAttachment(file.getFilename(), file);

		} catch (MessagingException e) {
			throw new MailParseException(e);
		}
		mailSender.send(message);
	}
}
