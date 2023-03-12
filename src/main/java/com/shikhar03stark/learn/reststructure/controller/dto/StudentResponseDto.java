package com.shikhar03stark.learn.reststructure.controller.dto;

public class StudentResponseDto {
    private String firstName;
    private String lastName;
    private String rollNumber;
    private Integer grade;
    private String section;
    private String readUrl;

    public StudentResponseDto(String firstName, String lastName, String rollNumber, Integer grade, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.section = section;
    }

    public StudentResponseDto(){}

    public String getReadUrl() {
        return readUrl;
    }

    public void setReadUrl(String readUrl) {
        this.readUrl = readUrl;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
