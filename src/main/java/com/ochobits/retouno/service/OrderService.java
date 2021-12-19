package com.ochobits.retouno.service;

import com.ochobits.retouno.model.Laptop;
import com.ochobits.retouno.model.Order;
import com.ochobits.retouno.repository.OrderRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpere
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private SequenceGeneratorService sequenceGenerator; 

    public List<Order> listar() {
        return orderRepository.listar();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order create(Order order) {
        if (order.getId() == null) {
            order.setId(sequenceGenerator.generateSequence(order.SEQUENCE_NAME));
            return orderRepository.create(order);
        } else {
            Optional<Order> order1 = orderRepository.getOrder(order.getId());
            if (order1.isEmpty()) {
                return orderRepository.create(order);
            } else {
                return order;
            }
        }
    }

    public Order update(Order order) {
        if (order.getId() == null) 
            return order;
            
        Optional<Order> orderDb = orderRepository.getOrder(order.getId());
        
        if (orderDb.isEmpty())
            return order;
        
        if (order.getProducts()!= null) {
            orderDb.get().setProducts(order.getProducts());
        }
        if (order.getQuantities()!= null) {
            orderDb.get().setQuantities(order.getQuantities());
        }
        if (order.getSalesMan()!= null) {
            orderDb.get().setSalesMan(order.getSalesMan());
        }
        if (order.getStatus()!= null) {
            orderDb.get().setStatus(order.getStatus());
        }
        
        orderRepository.update(orderDb.get());
        return orderDb.get();
    }
    public boolean delete(int id) {
        Optional<Order> order = orderRepository.getOrder(id);

        if (!order.isEmpty()) 
            orderRepository.delete(order.get());
        
        return !order.isEmpty();
    }

    public List<Order> getOrderByZona(String zona) {
        return orderRepository.getOrderByZona(zona);
    }

    public List<Order> getOrderBySalesman(int id) {
       return orderRepository.getOrderBySalesman(id);
    }

    public List<Order> getOrdersByDate(Date queryDate, int id) {
        return orderRepository.getOrdersByDate(queryDate, id);
    }

    public List<Order> getOrdersByState(String state, int id) {
        return orderRepository.getOrdersByState(state, id);
    }
}
