package com.cognizant.citizenservice.repository;

import com.cognizant.citizenservice.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    List<Feedback> findByCitizen(Integer citizen);
}
