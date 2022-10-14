package com.review.Review.repository;

import com.review.Review.responce.ResponseEntity;
import com.review.Review.pozo.Review;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author z0049vuf on 10/7/2022
 */
@Repository
public class ReviewDao implements IReviewDao {
    ArrayList<Review> reviewsList = new ArrayList<>();

    @Override
    public ResponseEntity<Review> addReview(Review review) {
        ResponseEntity<Review> reviewResponseEntity = null;
        int size = reviewsList.size();
        if (review.getReview().length() > 0) {
            reviewsList.add(review);
        }
        if (reviewsList.size() == size + 1) {
            reviewResponseEntity = new ResponseEntity<>();
            reviewResponseEntity.setMessage("Success");
            reviewResponseEntity.setStatusCode(200);
        } else {
            reviewResponseEntity = new ResponseEntity<>();
            reviewResponseEntity.setMessage("Failed");
            reviewResponseEntity.setStatusCode(400);
        }


        return reviewResponseEntity;
    }

    @Override
    public ResponseEntity<List<Review>> getReviews(String reviewDate, String storeType, Integer rating) {
        ResponseEntity<List<Review>> responseEntity = new ResponseEntity<>();
        List<Review> list = new ArrayList<>();

        if (storeType!=null && !storeType.isEmpty()  ) {
            for (Review review : reviewsList) {
                if (review.getStoretype().equals(storeType)) {
                    list.add(review);
                }
            }
        }
        if (rating != -1) {
            for (Review review : reviewsList) {
                if (review.getRating() == rating) {
                    list.add(review);
                }
            }
        }
        if(reviewDate!=null && reviewDate.length()>0){
            for (Review review : reviewsList) {
                if (review.getReviewed_date().equals( reviewDate)) {
                    list.add(review);
                }
            }
        }
        responseEntity.setMessage("Success");
        responseEntity.setStatusCode(200);
        responseEntity.setObject(list);
        return responseEntity;
    }

    @Override
    public ResponseEntity<Double> getAveragePerStore(String storeType) {
        ResponseEntity<Double> responseEntity = new ResponseEntity<>();
        OptionalDouble d= reviewsList.stream().filter(p->(p.getStoretype().toLowerCase()).equals((storeType.toLowerCase()))).mapToDouble(Review::getRating).average();

        responseEntity.setMessage("Success");
        responseEntity.setStatusCode(200);
        responseEntity.setObject(d.getAsDouble());
        return responseEntity;
    }

    @Override
    public ResponseEntity<Map<String, Long>> totalRatingEachCategory() {
        ResponseEntity<Map<String, Long>> responseEntity=new ResponseEntity<>();

       Map<String,Long> map= reviewsList.stream().collect(Collectors.groupingBy(o->o.getRating()+"",Collectors.counting()));
        responseEntity.setMessage("Success");
        responseEntity.setStatusCode(200);
        responseEntity.setObject(map);
        return responseEntity;
    }
}
