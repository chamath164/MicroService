package com.sliit.mtit.microservice.orderservice.controller;

import com.sliit.mtit.microservice.orderservice.dto.OrderRequest;
import com.sliit.mtit.microservice.orderservice.dto.OrderResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody OrderResponse createOrders(@RequestBody OrderRequest request){

        System.out.println(" Order Details : " + request);

        var OrderResponse = new OrderResponse();
        OrderResponse.setOrderId(UUID.randomUUID().toString());
        OrderResponse.setMessage("Successfully created the order");
        return OrderResponse;
    }
}
