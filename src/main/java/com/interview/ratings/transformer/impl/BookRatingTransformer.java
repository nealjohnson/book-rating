package com.interview.ratings.transformer.impl;

import com.interview.ratings.domain.entity.BookRatingEntity;
import com.interview.ratings.domain.model.BookRatingVO;
import com.interview.ratings.transformer.Transformer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BookRatingTransformer implements Transformer<BookRatingEntity, BookRatingVO> {
    @Override
    public BookRatingVO transformToModel(BookRatingEntity bookRatingEntity) {
        BookRatingVO bookRatingVO =new BookRatingVO();
        BeanUtils.copyProperties(bookRatingEntity,bookRatingVO);
        return bookRatingVO;
    }
}
