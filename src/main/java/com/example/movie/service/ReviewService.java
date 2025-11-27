package com.example.movie.service;

import com.example.movie.dto.ReviewRequest;
import com.example.movie.entity.Movie;
import com.example.movie.entity.MovieReview;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    private MovieRepository movieRepository;

    public List<MovieReview> getReviewsByMovieId(Integer movieId) {
        return reviewRepository.findByMovie_MovieId(movieId);
    }

    public MovieReview save(MovieReview movieReview) {
        return reviewRepository.save(movieReview);
    }

    public void deleteby(Integer id) {
        reviewRepository.deleteById(id);
    }


    public MovieReview saveReview(ReviewRequest reviewRequest) {

        Movie movie = movieRepository.findById(reviewRequest.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + reviewRequest.getMovieId()));

        MovieReview movieReview = new MovieReview();
        movieReview.setMovie(movie);
        movieReview.setRating(reviewRequest.getRating());
        movieReview.setComment(reviewRequest.getComment());

        return reviewRepository.save(movieReview);
    }

    public MovieReview updateReview(Integer id, ReviewRequest request) {

        MovieReview existing = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        existing.setRating(request.getRating());
        existing.setComment(request.getComment());
        existing.setReviewerName(request.getReviewerName());

        return reviewRepository.save(existing);
    }

}
