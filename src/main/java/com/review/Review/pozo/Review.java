package com.review.Review.pozo;

import java.util.Date;

/**
 * @author  on 10/7/2022
 */
public class Review {
    private String review;
    private String author;
    private String review_source;
    private Integer rating;
    private String title;
    private String product_name;
    private String reviewed_date;
    private String storetype;

    public String getStoretype() {
        return storetype;
    }

    public void setStoretype(String storetype) {
        this.storetype = storetype;
    }



    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReview_source() {
        return review_source;
    }

    public void setReview_source(String review_source) {
        this.review_source = review_source;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getReviewed_date() {
        return reviewed_date;
    }

    public void setReviewed_date(String reviewed_date) {
        this.reviewed_date = reviewed_date;
    }
}
