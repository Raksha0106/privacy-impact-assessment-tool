package com.internship.tool.service;

import com.internship.tool.entity.Assessment;
import com.internship.tool.repository.AssessmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(AssessmentRepository repo) {
        return args -> {

            // This loop inserts 30 records
            for (int i = 1; i <= 30; i++) {
                Assessment a = new Assessment();
                a.setName("Assessment " + i);
                repo.save(a);
            }

            System.out.println("✅ 30 records inserted successfully");
        };
    }
}