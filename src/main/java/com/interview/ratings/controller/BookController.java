package com.interview.ratings.controller;

import com.interview.ratings.domain.model.BookRatingVO;
import com.interview.ratings.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private RatingService ratingService;


    @Autowired
    public BookController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping(value = "rating/{userId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity bookName(@PathVariable("userId")  Long userId){
        List<BookRatingVO> result = ratingService.findBooksRating(userId);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
