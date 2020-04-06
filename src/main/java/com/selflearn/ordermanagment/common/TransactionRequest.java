package com.selflearn.ordermanagment.common;

import com.selflearn.ordermanagment.model.OrderDeatils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    private OrderDeatils order;
    private Payment payment;
}
