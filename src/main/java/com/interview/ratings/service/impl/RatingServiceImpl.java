package com.interview.ratings.service.impl;


import com.interview.ratings.domain.entity.BookRatingEntity;
import com.interview.ratings.domain.model.BookRatingVO;
import com.interview.ratings.repository.BookRatingRepository;
import com.interview.ratings.service.RatingService;
import com.interview.ratings.transformer.impl.BookRatingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    private BookRatingRepository ratingRepository;
    private BookRatingTransformer bookRatingTransformer;

    @Autowired
    public RatingServiceImpl(BookRatingRepository ratingRepository, BookRatingTransformer bookRatingTransformer) {
        this.ratingRepository = ratingRepository;
        this.bookRatingTransformer = bookRatingTransformer;
    }

    @Override
    public List<BookRatingVO> findBooksRating(Long userId) {
        List<BookRatingEntity> bookRatings = ratingRepository.findAllByUserId(userId);
        return bookRatings.stream().map(bookRatingTransformer::transformToModel).collect(Collectors.toList());

    }
}
