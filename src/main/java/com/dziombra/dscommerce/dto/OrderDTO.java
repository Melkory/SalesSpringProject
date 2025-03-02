package com.dziombra.dscommerce.dto;

import com.dziombra.dscommerce.entities.Order;
import com.dziombra.dscommerce.entities.OrderItem;
import com.dziombra.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;

    private ClientDTO client;

    private PaymentDTO payment;

    @NotEmpty(message = "Deve ter pelo menos 1 item!")
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO( Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment ) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO( Order entity ) {
        id = entity.getId();
        moment = entity.getMoment();
        this.status = entity.getStatus();
        this.client = new ClientDTO(entity.getClient());
        this.payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
        for (OrderItem item : entity.getItems()) {
            OrderItemDTO itemDto = new OrderItemDTO(item);
            items.add(itemDto);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment( Instant moment ) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus( OrderStatus status ) {
        this.status = status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient( ClientDTO client ) {
        this.client = client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment( PaymentDTO payment ) {
        this.payment = payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems( List<OrderItemDTO> items ) {
        this.items = items;
    }

    public Double getTotal () {
        double sum = 0;
        for (OrderItemDTO item : items) {
            sum = sum + item.getSubTotal();
        }
        return sum;
    }
}
