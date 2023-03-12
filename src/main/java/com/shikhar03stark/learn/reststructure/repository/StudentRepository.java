package com.shikhar03stark.learn.reststructure.repository;

import com.shikhar03stark.learn.reststructure.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

    Optional<StudentEntity> findByRollNumber(String rollNumber);
}
