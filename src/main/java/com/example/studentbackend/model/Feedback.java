package com.example.studentbackend.model;

import com.example.studentbackend.model.Student;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;
    private String question;

    @ManyToOne
    @JoinColumn(name = "regnumber")
    private Student student;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}



