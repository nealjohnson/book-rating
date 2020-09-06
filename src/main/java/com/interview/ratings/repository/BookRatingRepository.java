package com.interview.ratings.repository;

import com.interview.ratings.domain.entity.BookRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRatingRepository extends JpaRepository<BookRatingEntity,Long> {

    List<BookRatingEntity> findAllByUserId(Long id);
}
