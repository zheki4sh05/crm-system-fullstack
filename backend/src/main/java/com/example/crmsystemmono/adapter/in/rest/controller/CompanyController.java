package com.example.crmsystemmono.adapter.in.rest.controller;

import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.port.in.*;
import com.example.crmsystemmono.common.security.service.interfaces.*;
import io.swagger.v3.oas.annotations.tags.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Company controller")
@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    @Autowired
    private ICompanyControl companyControl;

    @Autowired
    private AuthenticatedUserData authenticatedUserData;

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody CompanyDto companyDto) {

            var user = authenticatedUserData.getCurrentUser();
            var createdCompanyDto =  companyControl.create(companyDto, user);
            return new ResponseEntity<>(createdCompanyDto, HttpStatus.CREATED);
    }

//    @PatchMapping("/update")
//    public ResponseEntity<?> update(@Valid @RequestBody CompanyDto companyDto) {
//        try {
//
//            CompanyDto createdCompanyDto  = companyControl.updateCompany(companyDto);
//
//            return new ResponseEntity<>(createdCompanyDto, HttpStatus.OK);
//        } catch (SuchEntityAlreadyExists e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//        }
//        catch (EntityNotFoundException e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//        catch (RuntimeException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
//    @GetMapping("/fetch")
//    public ResponseEntity<?> fetch() {
//        try {
//            UserEntity user = authenticatedUserData.getCurrentUser();
//
//            CompanyDto companyDto  = authUserDataControlFacade.fetch(user.getId());
//
//            return new ResponseEntity<>(companyDto, HttpStatus.OK);
//        }
//        catch (EntityNotFoundException e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//        catch (RuntimeException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }


//    @GetMapping("/user")
//    public ResponseEntity<?> companyByUser() {
//        User user = authenticatedUserData.getCurrentUser();
//
//            UUID companyId  = authUserDataControlFacade.companyUser(user.getId());
//
//            return new ResponseEntity<>(companyId, HttpStatus.OK);
//
//    }
}
