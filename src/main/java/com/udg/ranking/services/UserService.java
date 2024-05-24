package com.udg.ranking.services;

import com.udg.ranking.models.UserModel;
import com.udg.ranking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    //CRUD

    public UserModel saveUser(UserModel user){
        if(repository.findUserModelByName(user.getName()).toString().equals("Optional[[]]")){
            return repository.save(user);
        }else{
            //retornar un error de repetido
            UserModel userError = new UserModel();
                userError.setId(-1L);
            return userError;
        }



    }

    public ArrayList<UserModel> getAllUsers(){
        return (ArrayList<UserModel>) repository.findAll();
    }


    public Optional<UserModel> findUserById(Long id){
        return repository.findById(id);
    }

    public UserModel editUser(UserModel user){
        return repository.save(user);
    }

    public String deleteUserById(Long id){

        if(findUserById(id).isPresent()){
            repository.deleteById(id);
            return "user deleted successfully";
        }else {
            return "user with id="+ id+ " not foud";
        }
    }

    public Optional<ArrayList<UserModel>> findUserByCountry(String country){
        return repository.findUserModelByCountry(country);
    }
    public Optional<ArrayList<UserModel>> findUserByName(String name){
        return repository.findUserModelByName(name);
    }

    public Optional<ArrayList<UserModel>> findUserByVerified(String verified){
        return repository.findUserModelByVerified(verified);
    }

}
