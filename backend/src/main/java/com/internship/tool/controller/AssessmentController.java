package com.internship.tool.controller;

import com.internship.tool.entity.Assessment;
import com.internship.tool.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService service;

    // 🔹 GET API (you already have this)
    @GetMapping("/list")
    public List<Assessment> getAll() {
        return service.getAllList();
    }

    // 🔥 ADD THIS METHOD (POST API)
    @PostMapping("/add")
    public Assessment add(@RequestBody Assessment assessment) {
        return service.save(assessment);
    }
}