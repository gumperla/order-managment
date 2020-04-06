package com.selflearn.ordermanagment.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private int paymentID;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private int amount;
}
