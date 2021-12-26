package com.betaplan.himi.tvshows_exam.services;

import com.betaplan.himi.tvshows_exam.models.Rating;
import com.betaplan.himi.tvshows_exam.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
public Rating getOneRating(Long id){
    return ratingRepository.findById(id).orElse(null);
}
}
