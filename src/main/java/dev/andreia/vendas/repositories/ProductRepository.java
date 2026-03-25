package dev.andreia.vendas.repositories;

import dev.andreia.vendas.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
