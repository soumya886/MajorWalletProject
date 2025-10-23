package com.example.demo.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
	@Bean
	SimpleMailMessage getMailMessage() {
		  return new SimpleMailMessage();
	  }
	 @Bean
	 JavaMailSender getMailSender() {
		  JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
	        javaMailSender.setHost("smtp.gmail.com");
	       // javaMailSender.setPort(587);
	        javaMailSender.setPort(465);
	        javaMailSender.setUsername("soumyadhal2000@gmail.com"); // email of the system
	        javaMailSender.setPassword("wapjjvraubfyllmc"); // password of the system

	        Properties properties = javaMailSender.getJavaMailProperties();
	       // properties.put("mail.smtp.starttls.enable", true); // Very very imp to enable, otherwise mails will not be sent
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.debug", true);

		 return javaMailSender;
	 }
}
