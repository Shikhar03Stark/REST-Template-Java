package com.shikhar03stark.learn.reststructure.service.impl;

import com.shikhar03stark.learn.reststructure.controller.dto.StudentRequestDto;
import com.shikhar03stark.learn.reststructure.controller.dto.StudentResponseDto;
import com.shikhar03stark.learn.reststructure.entity.StudentEntity;
import com.shikhar03stark.learn.reststructure.mapper.StudentMapper;
import com.shikhar03stark.learn.reststructure.repository.StudentRepository;
import com.shikhar03stark.learn.reststructure.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    // On startup Spring created objects of all @Components
    // Spring looks at the ctor StudentServiceImpl
    // 1st Param requires object (bean) of StudentRepository

    // bean = context.getBean("StudentRepository", StudentRepository.class);
    // studentService = new StudentServiceImpl(bean);

    public StudentServiceImpl(final StudentRepository studentRepo, final StudentMapper mapper){
        // this.property = bean;
        this.studentRepository = studentRepo;
        this.studentMapper = mapper;
    }
    @Override
    public StudentResponseDto saveStudent(StudentRequestDto studentRequestDto) {
        final StudentEntity studentEntity = studentMapper.mapRequest(studentRequestDto);

        StudentEntity savedEntity = studentRepository.save(studentEntity);

        return studentMapper.mapEntity(savedEntity);
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
//        Stream API
//        studentEntities
//                .stream()
//                .map(entity -> studentMapper.mapEntity(entity))
//                .collect(Collectors.toList());
        List<StudentResponseDto> responseDtos = new ArrayList<>();
        for(final StudentEntity entity: studentEntities){
            responseDtos.add(studentMapper.mapEntity(entity));
        }
        return responseDtos;
    }

    @Override
    public StudentResponseDto getStudentDetail(String rollNumber) {
        StudentEntity studentEntity = studentRepository.findByRollNumber(rollNumber)
                .orElseThrow(() -> new RuntimeException("No Student with rollNumber="+rollNumber));

        return studentMapper.mapEntity(studentEntity);
    }

    @Override
    public void updateStudent(StudentRequestDto studentRequestDto) {
        StudentEntity studentEntity = studentMapper.mapRequest(studentRequestDto);
        studentRepository.findByRollNumber(studentEntity.getRollNumber())
                .orElseThrow(() -> new RuntimeException("No Student found with rollNumber"+studentEntity.getRollNumber()+". Create new Student."));

        studentRepository.save(studentEntity);
    }

    @Override
    public void deleteStudent(String rollNumber) {
        studentRepository.findByRollNumber(rollNumber)
                .ifPresent(entity -> studentRepository.deleteById(entity.getId()));
    }
}
