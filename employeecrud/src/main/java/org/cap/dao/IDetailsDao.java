package org.cap.dao;

import org.cap.entities.User;

public interface IDetailsDao {

    User findUserById(int id);

    User createUser(User user);

    User createUser(String username);
}
