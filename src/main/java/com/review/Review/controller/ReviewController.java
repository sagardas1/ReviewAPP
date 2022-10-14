package com.review.Review.controller;

import com.review.Review.pozo.Employee;
import com.review.Review.responce.ResponseEntity;
import com.review.Review.pozo.Review;
import com.review.Review.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author  on 10/7/2022
 */
@RestController
@RequestMapping("/review")
public class ReviewController {

    ArrayList<Review> reviewList = new ArrayList<>();
    @Autowired
    IService iService;

    //Accepts reviews and stores them
    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        ResponseEntity<Review> responseEntity = null;
        try {
            responseEntity = iService.addReview(review);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;

    }

    @GetMapping("/getReview")
    public ResponseEntity<List<Review>> getReviews(@RequestParam(required = false, defaultValue = "null") String reviewDate,
                                                   @RequestParam(required = false) String storeType,
                                                   @RequestParam(required = false, defaultValue = "-1") Integer rating) {
        ResponseEntity<List<Review>> responseEntity = null;
        try {
            responseEntity = iService.getReviews(reviewDate, storeType, rating);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;

    }

    @GetMapping("/getAvg")
    public ResponseEntity<Double> getAveragePerStore(
                                                   @RequestParam(required = false) String storeType) {
        ResponseEntity<Double> responseEntity = null;
        try {
            responseEntity = iService.getAveragePerStore(storeType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;

    }
    @GetMapping("/totalratingeachCategory")
    public ResponseEntity<Map<String,Long>> totalRatingEachCategory(
            ) {
        ResponseEntity<Map<String,Long>> responseEntity = null;
        try {
            responseEntity = iService.totalRatingEachCategory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;

    }



}
