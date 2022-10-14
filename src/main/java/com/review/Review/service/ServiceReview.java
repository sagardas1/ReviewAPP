package com.review.Review.service;

import com.review.Review.responce.ResponseEntity;
import com.review.Review.pozo.Review;
import com.review.Review.repository.IReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author z0049vuf on 10/7/2022
 */
@Service
public class ServiceReview implements IService{
@Autowired
    IReviewDao iReviewDao;
    @Override
    public ResponseEntity<Review> addReview(Review review) {
        return iReviewDao.addReview(review);
    }

    @Override
    public ResponseEntity<List<Review>> getReviews(String reviewDate, String storeType, Integer rating) {
         return iReviewDao.getReviews(reviewDate,storeType,rating);
    }

    @Override
    public ResponseEntity<Double> getAveragePerStore(String storeType) {
        return iReviewDao.getAveragePerStore(storeType);
    }

    @Override
    public ResponseEntity<Map<String, Long>> totalRatingEachCategory() {
        return iReviewDao.totalRatingEachCategory();
    }
}
