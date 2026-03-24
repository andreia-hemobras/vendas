package dev.andreia.vendas.repositories;

import dev.andreia.vendas.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
