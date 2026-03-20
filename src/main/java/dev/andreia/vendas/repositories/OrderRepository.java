package dev.andreia.vendas.repositories;

import dev.andreia.vendas.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
