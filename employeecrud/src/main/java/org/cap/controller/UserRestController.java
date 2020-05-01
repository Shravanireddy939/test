package org.cap.controller;

import org.cap.dao.UserNotFoundException;
import org.cap.entities.User;
import org.cap.service.IDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {

    @Autowired
    private IDetailsService detailsService;

    @RequestMapping(value = "/user/find/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<User> findUser(@PathVariable("id") int id) {
        User user = detailsService.findUserById(id);
        if (user == null) {
            throw new UserNotFoundException("user not found for id=" + id);
        }
        ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        System.out.println("response entity=" + responseEntity);
        return responseEntity;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity userNotFound(UserNotFoundException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/user/create",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = "application/json")
    public ResponseEntity<Boolean> createUser(@RequestBody User user) {
        user = detailsService.createUser(user);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
        System.out.println("response entity=" + responseEntity);
        return responseEntity;
    }



}
