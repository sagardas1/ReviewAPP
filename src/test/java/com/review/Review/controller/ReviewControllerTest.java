package com.review.Review.controller;

import com.review.Review.pozo.Review;
import com.review.Review.repository.ReviewDao;
import com.review.Review.responce.ResponseEntity;

import com.review.Review.service.ServiceReview;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * @author z0049vuf on 10/13/2022
 */

@SpringBootTest
public class ReviewControllerTest {


    @Autowired
    private ReviewController reviewController;

    @BeforeEach
    public void inti() {


    }

    @Test
    public void addReviewTest() {
        Review review = new Review();
        review.setReview("xyz");
        review.setRating(1);
        review.setStoretype("Google");
        ResponseEntity<Review> reviewResponseEntity = new ResponseEntity<>();
        reviewResponseEntity.setStatusCode(600);
        reviewResponseEntity = reviewController.addReview(review);
        Assertions.assertEquals(reviewResponseEntity.getStatusCode(), 200);

    }

    @Test
    public void getReviewsTest() {
        int rating = 1;
        String reviewDate = null;
        String storeType = "";
        ResponseEntity<List<Review>> responseEntity = null;
        responseEntity = reviewController.getReviews(reviewDate, storeType, rating);
        Assertions.assertTrue(responseEntity.getObject().size() > 0);

    }

    @Test
    public void getAveragePerStoreTest() {
        String storeType = "Google";
        ResponseEntity<Double> responseEntity = null;
        responseEntity = reviewController.getAveragePerStore(storeType);
        Assertions.assertTrue(responseEntity.getObject() > 0);

    }

    @Test
    public void totalRatingEachCategoryTest() {
        ResponseEntity<Map<String, Long>> responseEntity = null;
        responseEntity = reviewController.totalRatingEachCategory();
        Assertions.assertTrue(responseEntity.getObject().size() > 0);


    }


}
