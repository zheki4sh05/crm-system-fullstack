package com.example.crmsystemmono.file.controller;


import com.example.crmsystemmono.file.dto.*;
import com.example.crmsystemmono.file.exceptions.*;
import com.example.crmsystemmono.file.service.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController(value = "documents")
public class DocumentsController {

    private final IDocumentControl documentControl;

    @Autowired
    public DocumentsController(IDocumentControl documentControl) {
        this.documentControl = documentControl;
    }


    @CrossOrigin
    @PostMapping("/upload")
    public ResponseEntity<?> uploadDocument(@RequestHeader Map<String, String> headers,
                                            @ModelAttribute CreateDocRequest createDocRequest) {

        try {
            List<DocumentDto> documentDTOs = documentControl.upload(createDocRequest);
            return ResponseEntity.ok(documentDTOs);
        } catch (DataIntegrityViolationException | DocumentUploadException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (UnCorrectFileNameException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (NotSupportedExtension e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }




}
