package com.shikhar03stark.learn.reststructure.controller.dto;

// Describe the structure of dto that we want from the client (end-user)
public class StudentRequestDto {
    private String name;
    private String rollNumber;
    private Integer grade;
    private String section;

    public StudentRequestDto(String name, String rollNumber, Integer grade, String section) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.section = section;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
