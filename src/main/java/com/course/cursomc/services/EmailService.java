package com.course.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.course.cursomc.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}
