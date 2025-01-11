package com.example.crmsystemmono.file.dto;

import lombok.*;
import org.springframework.web.multipart.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class CreateDocRequest {

    private List<MultipartFile> file;
    private String category;
    private Long companyId;


}
