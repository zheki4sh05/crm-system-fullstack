package com.example.crmsystemmono.adapter.in.rest.controller;


import com.example.crmsystemmono.adapter.in.rest.dto.*;
import com.example.crmsystemmono.application.port.in.*;
import io.swagger.v3.oas.annotations.tags.*;
import jakarta.persistence.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Tag(name = "stage controller")
@RestController
@RequestMapping("/api/v1/stage")
public class StageController {

    @Autowired
    private IStageControl stageControl;

    @PostMapping("/create")
    public ResponseEntity<?> createStage(@Valid @RequestBody StageDto stageDto) {

            StageDto createdStageDto  = stageControl.create(stageDto, stageDto.companyId());
            return new ResponseEntity<>(createdStageDto, HttpStatus.CREATED);
    }

    @GetMapping("/fetch")
    public ResponseEntity<?> fetch(@RequestParam String companyId,
                                         @RequestParam String groupId) {
            List<StageDto> stageDtoList  = stageControl.fetch(companyId,groupId);
            return new ResponseEntity<>(stageDtoList, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam String companyId,
                                      @RequestParam String groupId,
                                      @RequestParam String stageId ) {


            stageControl.delete(UUID.fromString(companyId), UUID.fromString(groupId),UUID.fromString(stageId));

            return new ResponseEntity<>("", HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody StageDto stageDto) {

         StageDto updatedSto = stageControl.update(stageDto);

            return new ResponseEntity<>(updatedSto, HttpStatus.OK);
    }

}
