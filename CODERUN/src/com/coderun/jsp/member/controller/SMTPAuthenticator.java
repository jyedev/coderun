package com.coderun.jsp.member.controller;

import javax.mail.*;

public class SMTPAuthenticator extends Authenticator {
	public SMTPAuthenticator() {
		super();
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		String username = "이메일";
		String password = "비밀번호";
		return new PasswordAuthentication(username, password);
	}
}
