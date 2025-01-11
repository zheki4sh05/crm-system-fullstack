package com.example.crmsystemmono.adapter.in.rest.controller;


import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.port.in.*;
import com.example.crmsystemmono.common.security.service.interfaces.*;
import io.swagger.v3.oas.annotations.tags.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Tag(name = "group controller")
@RestController
@RequestMapping("/api/v1/group")
public class GroupController {

    @Autowired
    private IGroupControl groupControl;

    @Autowired
    private AuthenticatedUserData authenticatedUserData;

    @PostMapping("/")
    public ResponseEntity<?> createGroup(@Valid @RequestBody GroupDto groupDto) {
            var user = authenticatedUserData.getCurrentUser();
            var createdGroup  = groupControl.create(groupDto,user);
            return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> fetch() {
            var user = authenticatedUserData.getCurrentUser();
            var groupDtos = groupControl.fetch(user.getCompany().getId());
            return new ResponseEntity<>(groupDtos, HttpStatus.OK);

    }

    @DeleteMapping("/")
    public ResponseEntity<?> delete(@RequestParam String companyId,
                                    @RequestParam String groupId) {

            groupControl.delete(UUID.fromString(companyId), UUID.fromString(groupId));
            return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody GroupDto groupDto) {
            var user = authenticatedUserData.getCurrentUser();
            var updatedDto = groupControl.update(groupDto, user.getCompany());
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }






}
