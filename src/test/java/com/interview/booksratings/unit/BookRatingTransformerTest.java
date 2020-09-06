package com.interview.booksratings.unit;


import com.interview.ratings.domain.entity.BookRatingEntity;
import com.interview.ratings.domain.model.BookRatingVO;
import com.interview.ratings.transformer.Transformer;
import com.interview.ratings.transformer.impl.BookRatingTransformer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.math.BigDecimal;


@RunWith(MockitoJUnitRunner.class)
public class BookRatingTransformerTest {

    Transformer transformer;

    @Before
    public void prepare(){
        transformer= new BookRatingTransformer();
    }

    @Test
    public void testTransform() {
        Long userId =1l;
        Long bookId =2l;
        BigDecimal rating = new BigDecimal(2.0);
        BookRatingEntity bookRatingEntity =new BookRatingEntity();
        bookRatingEntity.setBookId(bookId);
        bookRatingEntity.setRating(rating);
        bookRatingEntity.setUserId(userId);

        BookRatingVO result = (BookRatingVO)transformer.transformToModel(bookRatingEntity);

        Assert.assertEquals( bookId, result.getBookId());
        Assert.assertEquals( rating,result.getRating());
    }

}
