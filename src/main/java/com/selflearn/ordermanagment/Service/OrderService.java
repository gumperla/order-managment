package com.selflearn.ordermanagment.Service;

import com.selflearn.ordermanagment.common.Payment;
import com.selflearn.ordermanagment.common.TransactionRequest;
import com.selflearn.ordermanagment.common.TransactionResponse;
import com.selflearn.ordermanagment.dao.OrderRepository;
import com.selflearn.ordermanagment.model.OrderDeatils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    @Lazy
    private RestTemplate template;
    @Value("${microsservice.payment-service.endpoints.endpoint.uri}")
    private String endpoint_URL;

    public TransactionResponse saveOrder(TransactionRequest request){
        String responseMessage;

        OrderDeatils order=request.getOrder();
        Payment payment=request.getPayment();
        payment.setOrderId(order.getOrderID());
        payment.setAmount(order.getAmount());
        // do a rest call
         //ResponseEntity<Payment> paymentResponse= template.postForEntity("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
        ResponseEntity<Payment> paymentResponse= template.postForEntity(endpoint_URL,payment,Payment.class);
         responseMessage= paymentResponse.getBody().getPaymentStatus().equals("success") ? "payment Success":"payment failed";
         repository.save(order);

         return new TransactionResponse(order,paymentResponse.getBody().getAmount(),paymentResponse.getBody().getTransactionId(),
                 responseMessage);
    }
}

