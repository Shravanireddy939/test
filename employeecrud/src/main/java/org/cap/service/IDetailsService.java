package org.cap.service;


import org.cap.entities.User;

public interface IDetailsService {

    User findUserById(int id);

    User createUser(User user);

    User createUser(String name);
}
