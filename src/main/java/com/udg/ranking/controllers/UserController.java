package com.udg.ranking.controllers;

import com.udg.ranking.models.UserModel;
import com.udg.ranking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return service.saveUser(user);
    }

    @PutMapping()
    public UserModel editUser(@RequestBody UserModel user){
        return service.editUser(user);
    }

    @GetMapping()
    public ArrayList<UserModel> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/findUserById/{id}")
    public Optional<UserModel> findUserById(@PathVariable Long id){
        return service.findUserById(id);
    }

    @GetMapping("/findUserByCountry/{country}")
    public Optional<ArrayList<UserModel>> findUserByCountry(@PathVariable String country){
        return service.findUserByCountry(country);
    }

    @GetMapping("/findUserByVerified/{verified}")
    public Optional<ArrayList<UserModel>> findUserByVerified(@PathVariable String verified){
        return service.findUserByVerified(verified);
    }


    @GetMapping("/findUserByName/{name}")
    public Optional<ArrayList<UserModel>> findUserByName(@PathVariable String name){
        return service.findUserByName(name);
    }
    @DeleteMapping("/delete-user-by-id")
    public String deleteUserById(@RequestParam("id") Long id){
        return service.deleteUserById(id);
    }


}
