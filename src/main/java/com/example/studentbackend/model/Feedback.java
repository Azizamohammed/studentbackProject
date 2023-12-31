package com.example.studentbackend.model;

import com.example.studentbackend.model.Student;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int feedbackId;
    public String question;

    
    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}



