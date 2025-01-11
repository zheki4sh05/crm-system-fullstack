package com.example.crmsystemmono.common.configuration;

import com.example.crmsystemmono.application.domain.service.impl.*;
import com.example.crmsystemmono.application.port.in.*;
import com.example.crmsystemmono.application.port.out.*;
import com.example.crmsystemmono.common.mapper.*;
import org.springframework.context.annotation.*;

@Configuration
public class BeanConfiguration {

    @Bean
    IStageControl stageService(IStageStorage stageStorage, IObjectMapper objectMapper){
        return new StageControlImpl(stageStorage, objectMapper);
    }

    @Bean
    ICompanyControl companyService(ICompanyStorage companyStorage, IRoleStorage roleStorage, IObjectMapper objectMapper){
        return new CompanyControlImpl(companyStorage, roleStorage, objectMapper);
    }

    @Bean
    IDealControl dealService(IDealStorage dealRepository,IStageStorage stageStorage, IObjectMapper objectMapper){
        return new DealControlImpl(dealRepository, stageStorage, objectMapper);
    }
    @Bean
    IGroupControl groupService(IGroupStorage groupStorage, IObjectMapper objectMapper){
        return new GroupControlImpl(groupStorage, objectMapper);
    }
    @Bean
    IOrderControl orderService(IOrderStorage orderStorage, IObjectMapper objectMapper){
        return new OrderImpl(orderStorage, objectMapper);
    }
}
