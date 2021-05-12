package com.sliit.mtit.microservice.orderservice.service;

import com.sliit.mtit.microservice.orderservice.dto.OrderRequest;
import com.sliit.mtit.microservice.orderservice.dto.OrderResponse;
import com.sliit.mtit.microservice.orderservice.dto.UserCreationRequest;
import com.sliit.mtit.microservice.orderservice.dto.UserCreationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class OrderServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    public OrderResponse createOrder(OrderRequest orderRequest){

        var UserCreationRequest = new UserCreationRequest();
        UserCreationRequest.setAge(orderRequest.getAge());
        UserCreationRequest.setFullName(orderRequest.getFullName());
        ResponseEntity<UserCreationResponse> userCreationResponse = restTemplate.postForEntity("http://localhost:8080/users", UserCreationRequest, UserCreationResponse.class);

        var OrderResponse = new OrderResponse();
        OrderResponse.setOrderId(UUID.randomUUID().toString());
        OrderResponse.setUserId(userCreationResponse.getBody().getUserId());
        OrderResponse.setMessage("Successfully created the order");

        return OrderResponse;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
