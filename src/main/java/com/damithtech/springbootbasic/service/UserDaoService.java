package com.damithtech.springbootbasic.service;

import com.damithtech.springbootbasic.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author DAMITH SAMARAKOON on 7/24/2020
 */
@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1, "adam", new Date()));
        users.add(new User(2, "brain", new Date()));
        users.add(new User(3, "newton", new Date()));
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOneUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User DeleteUserById(int id) {
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user.getId() == id) {
                userIterator.remove();
                return user;
            }
        }
        return null;
    }
}
