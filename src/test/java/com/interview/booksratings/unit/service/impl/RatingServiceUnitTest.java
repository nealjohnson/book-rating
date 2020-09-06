package com.interview.booksratings.unit.service.impl;

import com.google.common.collect.Lists;
import com.interview.ratings.domain.entity.BookRatingEntity;
import com.interview.ratings.domain.model.BookRatingVO;
import com.interview.ratings.repository.BookRatingRepository;
import com.interview.ratings.service.RatingService;
import com.interview.ratings.service.impl.RatingServiceImpl;
import com.interview.ratings.transformer.impl.BookRatingTransformer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RatingServiceUnitTest {
    @Mock
    BookRatingRepository bookRatingRepository;
    @Mock
    BookRatingTransformer bookRatingTransformer;

    RatingService ratingService;

    @Before
    public void prepare(){
        ratingService= new RatingServiceImpl(bookRatingRepository, bookRatingTransformer);
    }

    @Test
    public void testFindBooksRating() {
        Long userId =1l;
        Long bookId =2l;
        BigDecimal rating = new BigDecimal(2.0);
        BookRatingEntity bookRatingEntity =new BookRatingEntity();
        bookRatingEntity.setBookId(bookId);
        bookRatingEntity.setRating(rating);
        bookRatingEntity.setUserId(userId);
        List<BookRatingEntity> list = Lists.newArrayList(bookRatingEntity);
        BookRatingVO bookRatingVO = new BookRatingVO();
        bookRatingVO.setRating(rating);
        bookRatingVO.setBookId(bookId);
        Mockito.when(bookRatingRepository.findAllByUserId(userId)).thenReturn(list);
        Mockito.when(bookRatingTransformer.transformToModel(Mockito.isA(BookRatingEntity.class))).thenReturn(bookRatingVO);
        List<BookRatingVO> result = ratingService.findBooksRating(userId);

        Assert.assertEquals( bookId, result.get(0).getBookId());
        Assert.assertEquals( rating,result.get(0).getRating());
    }

}
