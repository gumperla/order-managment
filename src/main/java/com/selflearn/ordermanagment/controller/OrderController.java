package com.selflearn.ordermanagment.controller;

import com.selflearn.ordermanagment.Service.OrderService;
import com.selflearn.ordermanagment.common.Payment;
import com.selflearn.ordermanagment.common.TransactionRequest;
import com.selflearn.ordermanagment.common.TransactionResponse;
import com.selflearn.ordermanagment.model.OrderDeatils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){

        return service.saveOrder(request);

    }
}
