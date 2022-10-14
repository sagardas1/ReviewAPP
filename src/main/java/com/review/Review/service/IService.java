package com.review.Review.service;

import com.review.Review.responce.ResponseEntity;
import com.review.Review.pozo.Review;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author  on 10/7/2022
 */
public interface IService {
    ResponseEntity<Review> addReview(Review review);

    ResponseEntity<List<Review>> getReviews(String reviewDate, String storeType, Integer rating);

    ResponseEntity<Double> getAveragePerStore(String storeType);

    ResponseEntity<Map<String, Long>> totalRatingEachCategory();
}
