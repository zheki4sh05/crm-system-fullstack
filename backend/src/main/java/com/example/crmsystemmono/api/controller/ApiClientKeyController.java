package com.example.crmsystemmono.api.controller;

import com.example.crmsystemmono.api.dto.*;
import com.example.crmsystemmono.api.service.*;
import io.swagger.v3.oas.annotations.tags.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Tag(name = "api key controller")
@RestController
@RequestMapping("/api/v1/key")
public class ApiClientKeyController {

    @Autowired
    private IApiClientKeyControl apiClientKeyControl;

    @PostMapping("/generate")
    public ResponseEntity<?> generate(@RequestBody GenerateRequestDto generateRequestDto) {
        try {

            String key =  apiClientKeyControl.generate(UUID.fromString(generateRequestDto.getCompanyId()));

            return new ResponseEntity<>(key, HttpStatus.CREATED);
        }
        catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
