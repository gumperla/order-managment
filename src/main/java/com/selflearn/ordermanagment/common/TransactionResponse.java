package com.selflearn.ordermanagment.common;

import com.selflearn.ordermanagment.model.OrderDeatils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    private OrderDeatils order;
    private int amount;
    private String transactionId;
    private String responseMessage;
}
