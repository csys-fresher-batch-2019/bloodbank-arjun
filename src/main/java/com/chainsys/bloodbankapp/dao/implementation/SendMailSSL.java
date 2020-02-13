package com.chainsys.bloodbankapp.dao.implementation;

import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;


public class SendMailSSL 
{
	public static boolean send(final String from,final String password,String to,String sub,String msg) throws IOException
	{  
		Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() 
        {    
        	protected PasswordAuthentication getPasswordAuthentication() 
        	{    
        		return new PasswordAuthentication(from,password);  
        	}      
        });    
        try 
        {    
        	MimeMessage message = new MimeMessage(session);    
        	message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
        	message.setSubject(sub);    
        	BodyPart messageBodyPart1 = new MimeBodyPart();  
        	messageBodyPart1.setText("Greetings from Blood Bank");  
        	BodyPart messageBodyPart2 = new MimeBodyPart(); 
        	messageBodyPart2.setText("\n"+msg+"\n");
        	Multipart multipart = new MimeMultipart();  
        	BodyPart messageBodyPart3 = new MimeBodyPart();
        	messageBodyPart3.setText("Please Contact your HR \n 9898987656");
        	multipart.addBodyPart(messageBodyPart1);  
        	multipart.addBodyPart(messageBodyPart2);
        	multipart.addBodyPart(messageBodyPart3);
        	message.setContent(multipart );  
        	Transport.send(message);    
        	System.out.println("message sent successfully");  
        	return true;
        }
        catch (MessagingException e) 
        {
        	throw new RuntimeException(e);
        }    
	}
}

