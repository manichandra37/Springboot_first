package com.example.movie.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "review_table")
@Data
public class MovieReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rating")
    private int rating;

    @Column(name="comment")
    private String comment;

    @Column(name = "reviewer_name")
    private String reviewerName;

//    @Column(name = "movie_id")
//    private int movieId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

}
