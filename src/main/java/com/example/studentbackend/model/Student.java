package com.example.studentbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regnumber;
    private  String stuname;
    private  String  program;
    private String password;
    private String  campus;
    private String  email;
    private  String gender;


    public int getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(int regnumber) {
        this.regnumber = regnumber;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getEmail(String email) {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender(String gender) {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }}




