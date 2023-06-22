package com.example.studentbackend.repository;

import com.example.studentbackend.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo  extends JpaRepository<Feedback,Integer> {
}
