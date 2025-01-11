package com.example.crmsystemmono.adapter.out.persistense.adapter;

import com.example.crmsystemmono.adapter.out.persistense.entity.*;
import com.example.crmsystemmono.adapter.out.persistense.repository.*;
import com.example.crmsystemmono.application.domain.model.*;
import com.example.crmsystemmono.application.port.out.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class OrderAdapter implements IOrderStorage {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DealRepository dealRepository;

    @Override
    public OrderEntity create(IOrder dto, String userId) {
        var userIdParsed = Long.valueOf(userId);
        var targetDeal = dealRepository.findById(userIdParsed).orElseThrow(()->new EntityNotFoundException("Deal not found"));
        if(targetDeal.getEmployee().getId().equals(userId)){
            var newOrder = OrderEntity.builder()
                    .code(dto.getCode())
                    .count(dto.getCount())
                    .id(UUID.randomUUID())
                    .price(dto.getPrice())
                    .name(dto.getName())
                    .deal(targetDeal)
                    .build();

            return orderRepository.save(newOrder);
        }else{
            throw new EntityNotFoundException("Deal not found");
        }
    }
}
