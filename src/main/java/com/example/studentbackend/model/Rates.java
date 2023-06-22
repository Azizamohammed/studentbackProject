package com.example.studentbackend.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Rates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int  rateId;

    private  int rateNumber;
    private  int  feedId;

    @ManyToOne
    @JoinColumn(name = "feedbackId")
    private Feedback feedback;


    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public int getRateNumber() {
        return rateNumber;
    }

    public void setRateNumber(int rateNumber) {
        this.rateNumber = rateNumber;
    }

    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}
