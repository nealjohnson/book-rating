package com.interview.booksratings.unit.controller;

import com.google.common.collect.Lists;
import com.interview.ratings.controller.BookController;
import com.interview.ratings.domain.model.BookRatingVO;
import com.interview.ratings.service.RatingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerUnitTest {

    @Mock
    RatingService ratingService;

    BookController bookController;
    @Before
    public void prepare(){
        bookController= new BookController(ratingService);
    }

    @Test
    public void testRatingsList() {
        Long userId =1l;
        Long bookid =1l;
        BookRatingVO bookRatingVO =new BookRatingVO();
        bookRatingVO.setBookId(1L);
        bookRatingVO.setRating(new BigDecimal(1));
        List<BookRatingVO> list =Lists.newArrayList(bookRatingVO);
        Mockito.when(ratingService.findBooksRating(userId)).thenReturn(list);
        ResponseEntity result = bookController.bookName(userId);
        List<BookRatingVO> resultObj = (List<BookRatingVO>) result.getBody();
        Assert.assertEquals(new BigDecimal(1),resultObj.get(0).getRating());
        Assert.assertEquals(bookid,resultObj.get(0).getBookId());
    }

}
