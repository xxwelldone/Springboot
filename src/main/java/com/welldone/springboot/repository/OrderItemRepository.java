package com.welldone.springboot.repository;

import com.welldone.springboot.model.OrderItems;
import com.welldone.springboot.model.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItems, OrderItemPK> {
}
