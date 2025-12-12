package com.example.movie.service;

import com.example.movie.entity.Movie;
import com.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Optional<Movie> getMovieById(Integer id){

        return movieRepository.findById(id);
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie, Integer id){

        Movie mov = movieRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Movie not found with id: " + id));

        mov.setDesc(movie.getDesc());
        mov.setGenre(movie.getGenre());
        mov.setTitle(movie.getTitle());
        mov.setReleaseYear(movie.getReleaseYear());

        movieRepository.save(mov);
        return mov;

    }

    public Void deleteMovie(Integer id){

        movieRepository.deleteById(id);
        return null;
    }


    public List<Movie> searchMovies(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return List.of(); // return empty instead of full DB
        }
        return movieRepository.findByTitleContainingIgnoreCase(keyword);
    }

}
