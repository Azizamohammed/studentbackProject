package com.example.studentbackend.repository;

import com.example.studentbackend.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo  extends JpaRepository <Administrator, Integer> {
}
