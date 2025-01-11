package com.example.crmsystemmono.adapter.in.rest.controller;

import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.port.in.*;
import com.example.crmsystemmono.common.security.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

  @Autowired
  private IOrderControl orderControl;
  @Autowired
  private AuthenticatedUserData authenticatedUserData;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderDto dto) {
        var user  = authenticatedUserData.getCurrentUser();
        OrderDto orderDto  = orderControl.create(dto,user);
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }
}
