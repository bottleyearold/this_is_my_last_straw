package com.nlp.this_is_my_last_straw;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JobCriteriaRepository {

    private final JdbcTemplate jdbcTemplate;

    public JobCriteriaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Save method will now return JobCriteria instead of int
    public JobCriteria save(JobCriteria jobCriteria) {
        // Insert the jobCriteria into the database
        jdbcTemplate.update(
                "INSERT INTO job_criteria (job_name, coding_languages, gpa, prior_experience, preferred_locations, languages, weights) VALUES (?, ?, ?, ?, ?, ?, ?)",
                jobCriteria.getJobName(),
                String.join(", ", jobCriteria.getCodingLanguages()),  // Handling List to String conversion
                jobCriteria.getGpa(),
                jobCriteria.getPriorExperience(),
                String.join(", ", jobCriteria.getPreferredLocations()),  // Handling List to String conversion
                String.join(", ", jobCriteria.getLanguages()),  // Handling List to String conversion
                jobCriteria.getWeights()
        );
        // Return the same jobCriteria object that was inserted
        return jobCriteria;
    }
}

