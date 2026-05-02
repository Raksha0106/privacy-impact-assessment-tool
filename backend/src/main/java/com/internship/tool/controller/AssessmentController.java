package com.internship.tool.controller;

import com.internship.tool.entity.Assessment;
import com.internship.tool.service.AssessmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessments")
public class AssessmentController {

    private final AssessmentService service;

    public AssessmentController(AssessmentService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Assessment> getAll() {
        return service.getAllList();
    }

    @GetMapping("/{id}")
    public Assessment getById(@PathVariable Long id) {
        return service.getById(id);
    }
}