package dev.andreia.vendas.services;

import dev.andreia.vendas.entities.User;
import dev.andreia.vendas.repositories.UserRepository;
import dev.andreia.vendas.services.exceptions.DatabaseException;
import dev.andreia.vendas.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> opt = userRepository.findById(id);
        return opt.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        if (!userRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }

        try{
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException ex){
            throw new DatabaseException(ex.getMessage());
        }

    }

    public User update(Long id, User obj){
        try{
            User entity = userRepository.getReferenceById(id);
            updateData(obj, entity);
            return userRepository.save(entity);
        } catch (EntityNotFoundException ex){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User obj, User entity){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
