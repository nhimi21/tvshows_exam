package com.betaplan.himi.tvshows_exam.repositories;

import com.betaplan.himi.tvshows_exam.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    User findByEmail(String email);
    User findByName(String name);
    boolean existsByEmail(String email);
}
