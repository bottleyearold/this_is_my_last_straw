package com.nlp.this_is_my_last_straw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JobCriteriaController {

    @Autowired
    private JobCriteriaRepository jobCriteriaRepository;

    @PostMapping("/addJob")
    public ResponseEntity<JobCriteria> addJob(@RequestBody JobCriteria jobCriteria) {
        JobCriteria savedCriteria = jobCriteriaRepository.save(jobCriteria);
        return ResponseEntity.ok(savedCriteria); // Return the saved JobCriteria object in the response
    }
}
