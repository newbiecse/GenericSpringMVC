package com.learnspring.generic.scheduller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.learnspring.generic.comon.MailMail;

@Component("myBean")
public class MyBean {
 
	private MailMail mailMail;
	
	@Autowired(required=true)
	@Qualifier(value="mailMail")		
	public void setMailMail(MailMail mailMail) {
		this.mailMail = mailMail;
	}	

	public void senMail() {
		mailMail.sendMail("dear", "hello");
	}
	
    public void printMessage() {
    	mailMail.sendMail("dear", "hello");
        System.out.println("I am called by MethodInvokingJobDetailFactoryBean using SimpleTriggerFactoryBean");
        
    }
     
}