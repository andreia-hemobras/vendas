package dev.andreia.vendas.services;

import dev.andreia.vendas.entities.User;
import dev.andreia.vendas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return opt.get();
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User update(Long id, User obj){
        User entity = userRepository.getReferenceById(id);
        updateData(obj, entity);
        return userRepository.save(entity);
    }

    private void updateData(User obj, User entity){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
