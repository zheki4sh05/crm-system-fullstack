package com.example.crmsystemmono.file.service.interfaces;


import com.example.crmsystemmono.file.dto.*;
import com.example.crmsystemmono.file.exceptions.*;

import java.util.*;

public interface IDocumentControl {
   List<DocumentDto> upload(CreateDocRequest createDocRequest) throws DocumentUploadException, UnCorrectFileNameException, NotSupportedExtension;


}
