package com.betaplan.himi.tvshows_exam.repositories;

import com.betaplan.himi.tvshows_exam.models.Show;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends CrudRepository<Show,Long> {
   List<Show> findAll();
   boolean existsByTitle(String title);
   boolean existsByNetwork(String network);
}
