package com.springtest.rest.webservices.restfulwebservices.user;

import com.springtest.rest.webservices.restfulwebservices.utils.Dao;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoService implements Dao<User> {
    private List<User> userList = new ArrayList<>();
    private static int usersCount = 3;

    public UserDaoService(){
        userList.add(new User(1, "Then", new Date()));
        userList.add(new User(2, "Maka", new Date()));
        userList.add(new User(3, "Test", new Date()));
    }

    @Override
    public Optional<User> get(Integer id) {
        return Optional.ofNullable(userList.get(id));
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public User save(User user) {
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        userList.add(user);
        return user;
    }

    @Override
    public void update(User user) {
        userList.set(userList.indexOf(user),user);
    }

    @Override
    public User delete(Integer id) {
        Iterator<User> userIterator = userList.iterator();
        while (userIterator.hasNext()){
            User user = userIterator.next();
            if(user.getId() == id){
                userIterator.remove();
                return user;
            }
        }
        return null;
    }
}
