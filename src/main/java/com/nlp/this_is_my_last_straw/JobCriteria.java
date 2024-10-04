package com.nlp.this_is_my_last_straw;

import java.util.List;

public class JobCriteria {

    private String jobName;
    private List<String> codingLanguages;  // Changed from String to List<String>
    private Double gpa;
    private Integer priorExperience;
    private List<String> preferredLocations;  // Changed from String to List<String>
    private List<String> languages;  // Changed from String to List<String>
    private Double weights;

    // Getters and Setters
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public List<String> getCodingLanguages() {
        return codingLanguages;
    }

    public void setCodingLanguages(List<String> codingLanguages) {
        this.codingLanguages = codingLanguages;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Integer getPriorExperience() {
        return priorExperience;
    }

    public void setPriorExperience(Integer priorExperience) {
        this.priorExperience = priorExperience;
    }

    public List<String> getPreferredLocations() {
        return preferredLocations;
    }

    public void setPreferredLocations(List<String> preferredLocations) {
        this.preferredLocations = preferredLocations;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Double getWeights() {
        return weights;
    }

    public void setWeights(Double weights) {
        this.weights = weights;
    }
}
