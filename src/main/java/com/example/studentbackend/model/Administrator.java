package com.example.studentbackend.model;

import com.example.studentbackend.model.Feedback;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int admId;
    private  String admiName;
    private String  password;
    private String email;


    @ManyToOne
    @JoinColumn(name = "feedbackId")
    private Feedback feedback;


    public int getAdmId() {
        return admId;
    }

    public void setAdmId(int admId) {
        this.admId = admId;
    }

    public String getAdmiName() {
        return admiName;
    }

    public void setAdmiName(String admiName) {
        this.admiName = admiName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}



