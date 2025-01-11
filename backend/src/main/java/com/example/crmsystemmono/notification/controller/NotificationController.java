package com.example.crmsystemmono.notification.controller;


import com.example.crmsystemmono.notification.dto.*;
import com.example.crmsystemmono.notification.service.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Tag(name = "notification controller")
@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

    @Autowired
    private INotificationControl notificationControl;

    @PostMapping("/create")
    public ResponseEntity<?> send(NotificationDto notificationDto) {
        try {

             notificationControl.send(notificationDto);

            return new ResponseEntity<>( HttpStatus.OK);
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
