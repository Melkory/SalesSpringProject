package com.dziombra.dscommerce.services;

import com.dziombra.dscommerce.dto.CategoryDTO;
import com.dziombra.dscommerce.dto.OrderDTO;
import com.dziombra.dscommerce.dto.ProductDTO;
import com.dziombra.dscommerce.dto.ProductMinDTO;
import com.dziombra.dscommerce.entities.Category;
import com.dziombra.dscommerce.entities.Order;
import com.dziombra.dscommerce.entities.Product;
import com.dziombra.dscommerce.repositories.OrderRepository;
import com.dziombra.dscommerce.repositories.ProductRepository;
import com.dziombra.dscommerce.services.exceptions.DatabaseException;
import com.dziombra.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById ( Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO (order);
    }


}
