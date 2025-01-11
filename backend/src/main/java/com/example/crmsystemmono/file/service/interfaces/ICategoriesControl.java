package com.example.crmsystemmono.file.service.interfaces;


import com.example.crmsystemmono.file.dto.categories.*;
import com.example.crmsystemmono.file.exceptions.*;

import java.util.*;

public interface ICategoriesControl {
    List<CategoryDto> fetch(Long company);

    CategoryDto create(CreateCategoryRequest categoryRequest) throws SuchCategoryAlreadyExists;

    CategoryDto update(CreateCategoryRequest categoryRequest) throws SuchCategoryNotExists;

    void delete(Long id) throws SuchCategoryNotExists;
}
