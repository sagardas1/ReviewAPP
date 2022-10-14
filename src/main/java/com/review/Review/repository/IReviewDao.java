package com.review.Review.repository;

import com.review.Review.responce.ResponseEntity;
import com.review.Review.pozo.Review;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author z0049vuf on 10/7/2022
 */
public interface IReviewDao {
    ResponseEntity<Review> addReview(Review review);

    ResponseEntity<List<Review>> getReviews(String reviewDate, String storeType, Integer rating);

    ResponseEntity<Double> getAveragePerStore(String storeType);

    ResponseEntity<Map<String, Long>> totalRatingEachCategory();
}
