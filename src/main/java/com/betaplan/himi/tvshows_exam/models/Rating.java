package com.betaplan.himi.tvshows_exam.models;

import javax.persistence.*;


@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User rated;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show ratingShow;

    public Rating() {
    }

    public Rating(Long id, User rated, Show ratingShow) {
        this.id = id;
        this.rated = rated;
        this.ratingShow = ratingShow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRated() {
        return rated;
    }

    public void setRated(User rated) {
        this.rated = rated;
    }

    public Show getRatingShow() {
        return ratingShow;
    }

    public void setRatingShow(Show ratingShow) {
        this.ratingShow = ratingShow;
    }
}
