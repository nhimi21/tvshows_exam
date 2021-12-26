package com.betaplan.himi.tvshows_exam.repositories;

import com.betaplan.himi.tvshows_exam.models.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
    List<Rating> findAll();
}
