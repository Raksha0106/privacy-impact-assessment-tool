package com.internship.tool.service;

import com.internship.tool.entity.Assessment;
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

    // Create
    public Assessment createAssessment(Assessment assessment) {
        return repository.save(assessment);
    }

    // Get all with pagination
    public Page<Assessment> getAllAssessments(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // Get by id
    public Assessment getAssessmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));
    }

    // Update
    public Assessment updateAssessment(Long id, Assessment updatedAssessment) {

        Assessment existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));

        existing.setTitle(updatedAssessment.getTitle());
        existing.setDescription(updatedAssessment.getDescription());
        existing.setStatus(updatedAssessment.getStatus());

        return repository.save(existing);
    }

    // Delete
    public void deleteAssessment(Long id) {

        Assessment existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));

        repository.delete(existing);
    }

    // Get list
    public List<Assessment> getAllList() {
        return repository.findAll();
    }
}