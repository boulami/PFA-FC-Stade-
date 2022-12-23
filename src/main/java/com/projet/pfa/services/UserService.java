package com.projet.pfa.services;

import com.projet.pfa.collections.User;

import java.util.List;

public interface UserService {
    String save(User user);



    void delete(String id);


    List<User> getAll();
}
