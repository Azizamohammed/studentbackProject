package com.example.studentbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class User {
    @Id
    public String userId;
    public String password;
    public String userStatus;


    
}
