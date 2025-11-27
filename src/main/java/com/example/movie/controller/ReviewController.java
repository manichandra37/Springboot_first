package com.example.movie.controller;

import com.example.movie.dto.ReviewRequest;
import com.example.movie.entity.MovieReview;
import com.example.movie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public MovieReview addReview(@RequestBody ReviewRequest reviewRequest){
        return reviewService.saveReview(reviewRequest);
    }

    @PutMapping("/{id}")
    public MovieReview updateReview(@PathVariable Integer id,@RequestBody ReviewRequest reviewRequest){

        return reviewService.updateReview(id,reviewRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Integer id){
        reviewService.deleteReview(id);
    }
}
