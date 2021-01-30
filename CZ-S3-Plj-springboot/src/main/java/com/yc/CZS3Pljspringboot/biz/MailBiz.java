package com.yc.CZS3Pljspringboot.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailBiz {
	@Autowired
     private JavaMailSender mailSender;
     @Value("${mail.from.addr}")
     private String from;
     
     public void sendSimpleMail(String to,String subject,String content) {
    	 SimpleMailMessage message=new SimpleMailMessage();
    	 message.setFrom(from);
    	 message.setTo(to);
    	 message.setSubject(subject);
    	 message.setText(content);
    	 mailSender.send(message);
     }
}
