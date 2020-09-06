package com.interview.ratings.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data @Entity
@Table(name = "user_books_rating")
public class BookRatingEntity {

    @Id
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "book_id")
    private Long bookId;
    @Column
    private BigDecimal  rating;
}
