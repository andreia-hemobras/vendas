package dev.andreia.vendas.services;

import dev.andreia.vendas.entities.Order;
import dev.andreia.vendas.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> opt = orderRepository.findById(id);
        return opt.get();
    }
}
