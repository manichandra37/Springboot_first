package com.example.movie.controller;

import com.example.movie.entity.Movie;
import com.example.movie.entity.MovieReview;
import com.example.movie.service.MovieService;
import com.example.movie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public Optional<Movie> getMovieDetails(@PathVariable Integer id) {

        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie save(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

}
