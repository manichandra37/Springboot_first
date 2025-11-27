package com.example.movie.repository;

import com.example.movie.entity.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<MovieReview, Integer> {

    List<MovieReview> findByMovie_MovieId(Integer movieId);

}
