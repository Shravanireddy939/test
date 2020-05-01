package org.cap.dao;

import org.cap.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

/**
 * marking with @Repository is similar to @Component but used for Dao implementation classes,
 * spring will keep instance of DetailsDaoImpl and the object will be kept in bean factory
 *
 */
@Repository//@Service,@Component,@Entity
public class DetailsDaoImpl implements IDetailsDao {

    @PersistenceContext
    private EntityManager em;

    public DetailsDaoImpl(){
    }

    @Override
    public User findUserById(int id) {
      User u= em.find(User.class,id);
      return u;
    }

    @Override
    public User createUser(User user){
        user=em.merge(user);
        return user;
    }

    @Override
    public User createUser(String name) {
        User user=new User();
        user.setName(name);
        user=em.merge(user);
        return user;
    }
}
