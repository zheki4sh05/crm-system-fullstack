package com.example.crmsystemmono.adapter.in.rest.controller;


import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.port.in.*;
import com.example.crmsystemmono.common.security.service.interfaces.*;
import io.swagger.v3.oas.annotations.tags.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@Tag(name = "deal controller")
@RestController
@RequestMapping("/api/v1/deal")
public class DealController {

   @Autowired
   private IDealControl dealControl;

   @Autowired
   private AuthenticatedUserData authenticatedUserData;

    @PostMapping("/")
    public ResponseEntity<?> create( @RequestBody DealDto dealDto) {
        var user = authenticatedUserData.getCurrentUser();
        return new ResponseEntity<>(
                dealControl.createDealByUserId(dealDto, user),
                HttpStatus.CREATED
        );}

    @PatchMapping("/status")
    public ResponseEntity<?> move(@Valid DealDto dealDto) {
        var user = authenticatedUserData.getCurrentUser();
        var updatedDeal = dealControl.move(dealDto, user.getCompany().getId());
        return new ResponseEntity<>(updatedDeal, HttpStatus.OK);
    }

    @PatchMapping("/info")
    public ResponseEntity<?> update(@Valid DealDto dealDto) {
        var user = authenticatedUserData.getCurrentUser();
        var updatedDeal = dealControl.update(dealDto, user.getId().toString());
        return new ResponseEntity<>(updatedDeal, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> fetch() {
        return new ResponseEntity<>(null, HttpStatus.OK);

    }




}
