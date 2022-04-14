package tran.tuananh.service;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;

import tran.tuananh.model.User;

public interface MailService {

	public String sendEmail(User user) throws MailException;

	public String sendEmailWithAttachment(User user) throws MailException, MessagingException;
}
