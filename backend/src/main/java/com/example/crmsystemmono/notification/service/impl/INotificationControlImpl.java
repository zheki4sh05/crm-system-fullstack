package com.example.crmsystemmono.notification.service.impl;


import com.example.crmsystemmono.notification.dto.*;
import com.example.crmsystemmono.notification.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.*;

@Service
public class INotificationControlImpl implements INotificationControl {

    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void send(NotificationDto notificationDto) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(notificationDto.getMailFrom());
        message.setTo(notificationDto.getMailTo());
        message.setText(notificationDto.getBody());
        message.setSubject(notificationDto.getSubject());
        mailSender.send(message);

    }
}
