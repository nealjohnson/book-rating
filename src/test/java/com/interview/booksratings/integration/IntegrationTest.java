package com.interview.booksratings.integration;

import com.interview.ratings.controller.BookController;
import com.interview.ratings.domain.model.BookRatingVO;
import com.interview.ratings.service.RatingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MocksApplication.class)
public class IntegrationTest {


    BookController bookController;

    @Autowired
    RatingService ratingService;

    @Before
    public void prepare(){
        bookController= new BookController(ratingService);
    }

    @Test
    public void testRatingsWorkingProperly() {
        Long userId =1l;
        Long bookId =1l;
        ResponseEntity result = bookController.bookName(userId);
        List<BookRatingVO> ratingVOList = (List<BookRatingVO>) result.getBody();
        Assert.assertEquals(4,ratingVOList.size());
        Assert.assertEquals(bookId, ratingVOList.get(0).getBookId());
        Assert.assertEquals(new BigDecimal("1.50"), ratingVOList.get(0).getRating());
        Assert.assertEquals(Long.valueOf(2), ratingVOList.get(1).getBookId());
        Assert.assertEquals(new BigDecimal("5.50"), ratingVOList.get(1).getRating());
    }
}
