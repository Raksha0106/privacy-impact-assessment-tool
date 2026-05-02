package com.internship.tool.service;

import com.internship.tool.entity.Assessment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssessmentService {

    public List<Assessment> getAllList() {
        return new ArrayList<>();
    }

    public Assessment getById(Long id) {
        return new Assessment();
    }
}