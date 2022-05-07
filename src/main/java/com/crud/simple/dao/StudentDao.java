package com.crud.simple.dao;

import com.crud.simple.entity.StudentEntity;

import java.util.List;

public interface StudentDao {
    StudentEntity saveStudent(StudentEntity studentEntity);

    StudentEntity getStudentById(Long id);

    void deleteStudentById(Long id);

    List<StudentEntity> getAllStudents();

    List<StudentEntity> getByName(String name);

    void  deleteByName(String name);
}
