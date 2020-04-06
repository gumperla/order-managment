package com.selflearn.ordermanagment.dao;

import com.selflearn.ordermanagment.model.OrderDeatils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDeatils,Integer> {
}
