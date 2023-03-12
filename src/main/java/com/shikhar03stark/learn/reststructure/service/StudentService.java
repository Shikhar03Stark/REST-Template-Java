package com.shikhar03stark.learn.reststructure.service;

import com.shikhar03stark.learn.reststructure.controller.dto.StudentRequestDto;
import com.shikhar03stark.learn.reststructure.controller.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {
    StudentResponseDto saveStudent(StudentRequestDto studentRequestDto);
    List<StudentResponseDto> getAllStudents();
    StudentResponseDto getStudentDetail(String rollNumber);
    void updateStudent(StudentRequestDto studentRequestDto);
    void deleteStudent(String rollNumber);

}
