package com.interview.ratings.service;

import com.interview.ratings.domain.model.BookRatingVO;

import java.util.List;

public interface RatingService {
     List<BookRatingVO> findBooksRating(Long userId);
}
