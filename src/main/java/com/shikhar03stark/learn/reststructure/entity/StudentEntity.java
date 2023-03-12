package com.shikhar03stark.learn.reststructure.entity;

import jakarta.persistence.*;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstName;
    private String lastName;
    private String rollNumber;
    private Integer grade;
    private String section;

    public StudentEntity(){}

    public StudentEntity(String id, String firstName, String lastName, String rollNumber, Integer grade, String section) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.section = section;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
