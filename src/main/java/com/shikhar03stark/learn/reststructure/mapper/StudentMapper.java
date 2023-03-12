package com.shikhar03stark.learn.reststructure.mapper;

import com.shikhar03stark.learn.reststructure.controller.dto.StudentRequestDto;
import com.shikhar03stark.learn.reststructure.controller.dto.StudentResponseDto;
import com.shikhar03stark.learn.reststructure.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentEntity mapRequest(StudentRequestDto studentRequestDto){
        StudentEntity entity = new StudentEntity();
        // name = "Shruty Khullar Vishwakarma"
        final String firstName = studentRequestDto.getName().split(" ")[0];
        final String lastName = studentRequestDto.getName().split(" ")[1];

        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setGrade(studentRequestDto.getGrade());
        entity.setRollNumber(studentRequestDto.getRollNumber());
        entity.setSection(studentRequestDto.getSection());
        return entity;
    }

    public StudentResponseDto mapEntity(StudentEntity studentEntity) {
        StudentResponseDto responseDto = new StudentResponseDto();
        responseDto.setFirstName(studentEntity.getFirstName());
        responseDto.setLastName(studentEntity.getLastName());
        responseDto.setRollNumber(studentEntity.getRollNumber());
        responseDto.setGrade(studentEntity.getGrade());
        responseDto.setSection(studentEntity.getSection());
        return responseDto;
    }
}
