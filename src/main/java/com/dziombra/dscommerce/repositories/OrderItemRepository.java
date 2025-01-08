package com.dziombra.dscommerce.repositories;

import com.dziombra.dscommerce.entities.OrderItem;
import com.dziombra.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
