package com.interview.ratings.transformer;

public interface  Transformer<T,R> {
      R transformToModel(T t);
}
