package com.internship.tool.service;

import com.internship.tool.entity.Assessment;
import com.internship.tool.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository repo;

    // 🔹 GET all
    public List<Assessment> getAllList() {
        return repo.findAll();
    }

    // 🔥 SAVE (this is what you asked)
    public Assessment save(Assessment assessment) {
        return repo.save(assessment);
    }
}