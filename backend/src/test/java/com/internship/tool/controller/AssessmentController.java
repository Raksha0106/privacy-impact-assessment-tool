package com.internship.tool.controller;

import com.internship.tool.entity.Assessment;
import com.internship.tool.service.AssessmentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService service;

    @GetMapping("/all")
    public Page<Assessment> getAllAssessments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return service.getAllAssessments(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Assessment getAssessmentById(@PathVariable Long id) {
        return service.getAssessmentById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Assessment createAssessment(@Valid @RequestBody Assessment assessment) {
        return service.createAssessment(assessment);
    }

    @PutMapping("/update/{id}")
    public Assessment updateAssessment(
            @PathVariable Long id,
            @Valid @RequestBody Assessment assessment) {

        return service.updateAssessment(id, assessment);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAssessment(@PathVariable Long id) {
        service.deleteAssessment(id);
    }

    @GetMapping("/list")
    public List<Assessment> getAllList() {
        return service.getAllList();
    }
}