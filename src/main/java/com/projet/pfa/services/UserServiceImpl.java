package com.projet.pfa.services;

import com.projet.pfa.collections.User;
import com.projet.pfa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public String save(User user) {

        return userRepository.save(user).getId();
    }



    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


}
