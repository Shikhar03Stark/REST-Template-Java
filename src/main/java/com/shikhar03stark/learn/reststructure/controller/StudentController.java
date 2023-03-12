package com.shikhar03stark.learn.reststructure.controller;

import com.shikhar03stark.learn.reststructure.controller.dto.StudentRequestDto;
import com.shikhar03stark.learn.reststructure.controller.dto.StudentResponseDto;
import com.shikhar03stark.learn.reststructure.service.StudentService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(final StudentService studentService){
        this.studentService = studentService;
    }

    // DTO : Data transfer Object
    // StudentEntity (Id, roll_number, class, section, name)
    // {name: "Shruty" class: 2 section: "A"} -> {id: "database", name: shruty, class, section}
    @PostMapping("/")
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto responseDto = studentService.saveStudent(studentRequestDto);
        responseDto.setReadUrl("http://localhost:9000/v1/student/"+responseDto.getRollNumber());
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{rollNumber}")
    public ResponseEntity<StudentResponseDto> getStudentDetail(@PathVariable("rollNumber") String rollNumber){
        StudentResponseDto responseDto = studentService.getStudentDetail(rollNumber);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDto>> findAllStudent(){
        List<StudentResponseDto> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
