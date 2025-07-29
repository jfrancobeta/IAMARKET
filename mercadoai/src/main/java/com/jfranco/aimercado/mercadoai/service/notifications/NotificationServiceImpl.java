package com.jfranco.aimercado.mercadoai.service.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.model.Notification.Notification;
import com.jfranco.aimercado.mercadoai.repository.notifications.NotificationRepository;

@Service
public class NotificationServiceImpl implements INotificationService {

    @Autowired
    private  NotificationRepository notificationRepository;

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public Notification createNotification(Notification notification) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notification.getEmail());
        message.setSubject(notification.getTitle());
        message.setText(notification.getMessage());
        mailSender.send(message);
        return notificationRepository.save(notification);
    }


    
    
}
