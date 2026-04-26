package com.internship.tool.service;

import com.internship.tool.entity.Assessment;
import com.internship.tool.repository.AssessmentRepository;
import com.internship.tool.exception.InvalidInputException;
import com.internship.tool.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository repository;

    public Assessment saveAssessment(Assessment assessment) {

        if (assessment.getProjectName() == null || assessment.getProjectName().isEmpty()) {
            throw new InvalidInputException("Project name is required");
        }

        return repository.save(assessment);
    }

    public List<Assessment> getAllAssessments() {
        return repository.findAll();
    }

    public Assessment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));
    }
}