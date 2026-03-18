package dev.andreia.vendas.repositories;

import dev.andreia.vendas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
