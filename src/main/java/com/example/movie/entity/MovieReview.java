package com.example.movie.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "movieId")
    @JsonBackReference
    private Movie movie;

}
