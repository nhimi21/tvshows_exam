package com.betaplan.himi.tvshows_exam.validator;

import com.betaplan.himi.tvshows_exam.models.Show;
import com.betaplan.himi.tvshows_exam.models.User;
import com.betaplan.himi.tvshows_exam.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.xml.validation.Validator;

@Component
public class ShowValidator  {
    @Autowired
    private ShowRepository showRepository;

    public void validate(Object target, Errors errors) {
        Show show = (Show) target;
        if (this.showRepository.existsByTitle(show.getTitle())) {
            errors.rejectValue("title", "Unique","Title is unique!");
        }
         if (this.showRepository.existsByNetwork(show.getNetwork())) {
        errors.rejectValue("network", "Unique","Network is unique!");
       }
    }
}
