package com.example.assignment4;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findStudentByStudentId(Integer studentId);
}
