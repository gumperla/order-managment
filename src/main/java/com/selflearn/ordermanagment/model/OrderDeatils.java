package com.selflearn.ordermanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Tb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDeatils {
    @Id
    private Integer orderID;
    private String orderName;
    private Integer amount;

}
