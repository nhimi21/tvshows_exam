package com.betaplan.himi.tvshows_exam.services;

import com.betaplan.himi.tvshows_exam.models.Show;
import com.betaplan.himi.tvshows_exam.models.User;
import com.betaplan.himi.tvshows_exam.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    //find all Shows
    public List<Show> findAllShows(){
        return this.showRepository.findAll();
    }
    //create and update show
    public Show createAnEditShow(Show show){
        return this.showRepository.save(show);
    }
    //Find show by id
    public Show finShowById(Long id){
        return this.showRepository.findById(id).orElse(null);
    }
    //Delete show
    public void deleteShow(Long id) {
        boolean exists = showRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Show with id" + id + "does not exists");
        }
        this.showRepository.deleteById(id);
    }
//    public void ratingShow(User user, Show show){
//        List<User> userWhoRated = show.;
//        userWhoRated.add(user);
//        this.showRepository.save(show);
//    }
}
