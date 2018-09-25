package com.springtest.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.getAll();
    }

    @GetMapping("/users/{userId}")
    public Resource<User> getUserbyId(@PathVariable int userId){
        if(!userDaoService.get(userId).isPresent()){
            throw new UserNotFoundException("id- "+userId);
        }
        Resource<User> resource = new Resource<User>(userDaoService.get(userId).get());
        ControllerLinkBuilder linkTo =ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userId}")
    public User deletebyId(@PathVariable int userId){
        User user = userDaoService.delete(userId);
        if(user == null){
            throw new UserNotFoundException("id- "+userId);
        }
        return user;
    }
}
