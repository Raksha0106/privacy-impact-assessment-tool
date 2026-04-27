package com.internship.tool.service;

import com.internship.tool.entity.Assessment;
import com.internship.tool.exception.InvalidInputException;
import com.internship.tool.exception.ResourceNotFoundException;
import com.internship.tool.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository repository;

    // CREATE
    public Assessment saveAssessment(Assessment assessment) {

        if (assessment.getProjectName() == null || assessment.getProjectName().isEmpty()) {
            throw new InvalidInputException("Project name is required");
        }

        return repository.save(assessment);
    }

    // GET ALL
    public List<Assessment> getAllAssessments() {
        return repository.findAll();
    }

    // GET ALL PAGINATED
    public Page<Assessment> getAllPaginated(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // GET BY ID
    public Assessment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));
    }
}