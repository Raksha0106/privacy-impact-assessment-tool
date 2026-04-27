package com.internship.tool.controller;

import com.internship.tool.entity.Assessment;
import com.internship.tool.service.AssessmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService service;

    // GET ALL PAGINATED
    @GetMapping("/all")
    public Page<Assessment> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return service.getAllPaginated(PageRequest.of(page, size));
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Assessment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // CREATE
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Assessment create(@Valid @RequestBody Assessment assessment) {
        return service.saveAssessment(assessment);
    }
}