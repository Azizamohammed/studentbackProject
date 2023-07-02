package com.example.studentbackend.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Rates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int  rateId;

    private  String rateStatus;


    @ManyToOne
    @JoinColumn(name = "feedbackId")
    public Feedback feedback;


    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public String getRateStatus() {
        return rateStatus;
    }

    public void setRateNumber(int rateNumber) {
        this.rateStatus = rateStatus;
    }


    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}
