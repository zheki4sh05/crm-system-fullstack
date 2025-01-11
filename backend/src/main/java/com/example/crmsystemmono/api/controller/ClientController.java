//package com.example.crmsystemmono.api.controller;
//
//import com.example.crmsystemmono.api.dto.*;
//import com.example.crmsystemmono.api.exceptions.*;
//import com.example.crmsystemmono.api.facade.*;
//import io.swagger.v3.oas.annotations.security.*;
//import io.swagger.v3.oas.annotations.tags.*;
//import jakarta.persistence.*;
//import jakarta.validation.*;
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//
//@Tag(name = "client controller")
//@RestController
//@RequestMapping("/api/v1/customer")
//@SecurityRequirement(name="bearerAuth")
//public class ClientController {
//
//    @Autowired
//    private IAuthenticatedClientDataFacade authenticatedClientDataFacade;
//
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@Valid @RequestBody CustomerDto customerDto) {
//        try {
//
//            authenticatedClientDataFacade.addCustomer(customerDto);
//
//            return new ResponseEntity<>("", HttpStatus.CREATED);
//        }
//        catch (SuchEntityAlreadyExistsException e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//        }
//        catch (EntityNotFoundException e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//        catch (RuntimeException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<?> update(@Valid @RequestBody CustomerDto customerDto) {
//        try {
//
//            authenticatedClientDataFacade.updateCustomer(customerDto);
//
//            return new ResponseEntity<>("", HttpStatus.OK);
//        }
//        catch (EntityNotFoundException e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//        catch (RuntimeException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//}
