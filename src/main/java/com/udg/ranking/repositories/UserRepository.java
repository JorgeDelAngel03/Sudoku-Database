package com.udg.ranking.repositories;

import com.udg.ranking.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    public Optional<ArrayList<UserModel>> findUserModelByCountry(String country);

    public Optional<ArrayList<UserModel>> findUserModelByName(String name);
    public Optional<ArrayList<UserModel>> findUserModelByVerified(String verified);
}
