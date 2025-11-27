package com.example.movie.dto;

import lombok.Data;

@Data
public class ReviewRequest {

    private Integer movieId;
    private int rating;
    private String comment;
    private String reviewerName;
}
