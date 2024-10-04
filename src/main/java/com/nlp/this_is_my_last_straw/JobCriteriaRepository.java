package com.nlp.this_is_my_last_straw;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JobCriteriaRepository {

    private final JdbcTemplate jdbcTemplate;

    public JobCriteriaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Save method to insert JobCriteria into the database
    public JobCriteria save(JobCriteria jobCriteria) {
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
        return jobCriteria;
    }

    // Custom findAll method to get all JobCriteria from the database
    public List<JobCriteria> findAll() {
        String sql = "SELECT * FROM job_criteria";
        return jdbcTemplate.query(sql, this::mapRowToJobCriteria);
    }

    // Helper method to map SQL result set to JobCriteria object
    private JobCriteria mapRowToJobCriteria(ResultSet rs, int rowNum) throws SQLException {
        JobCriteria jobCriteria = new JobCriteria();
        jobCriteria.setJobName(rs.getString("job_name"));
        jobCriteria.setCodingLanguages(List.of(rs.getString("coding_languages").split(", ")));
        jobCriteria.setGpa(rs.getDouble("gpa"));
        jobCriteria.setPriorExperience(rs.getInt("prior_experience"));
        jobCriteria.setPreferredLocations(List.of(rs.getString("preferred_locations").split(", ")));
        jobCriteria.setLanguages(List.of(rs.getString("languages").split(", ")));
        jobCriteria.setWeights(rs.getDouble("weights"));
        return jobCriteria;
    }
}
