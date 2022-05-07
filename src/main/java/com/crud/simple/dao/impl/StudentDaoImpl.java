package com.crud.simple.dao.impl;

import com.crud.simple.dao.StudentDao;
import com.crud.simple.entity.StudentEntity;
import com.crud.simple.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class StudentDaoImpl implements StudentDao {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentEntity saveStudent(StudentEntity studentEntity) {
        log.debug("Persisting student entity into db");
        return studentRepository.save(studentEntity);
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        log.debug("Getting student by id: {} from db",id);
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentById(Long id) {
        log.debug("Delete student by id: {} from db",id);
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        log.debug("Get all students from db");
        return studentRepository.findAll();
    }

    @Override
    public List<StudentEntity> getByName(String name) {
        log.debug("Get all students from db by  name: {}",name);
        return studentRepository.findAllByName(name);
    }

    @Override
    public void deleteByName(String name) {
        log.debug("Delete all students from db by  name: {}",name);
        studentRepository.deleteAllByName(name);
    }
}
