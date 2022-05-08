package com.crud.simple.servive.impl;

import com.crud.simple.ExceptionHandler.NotFound;
import com.crud.simple.dao.StudentDao;
import com.crud.simple.entity.StudentEntity;
import com.crud.simple.model.request.StudentRequest;
import com.crud.simple.model.response.StudentData;
import com.crud.simple.servive.StudentService;
import com.crud.simple.util.EntityToDataConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public List<StudentData> getAllStudents() {
        List<StudentData> students = new ArrayList<>();
        List<StudentEntity> studentEntities = studentDao.getAllStudents();
        if (studentEntities!= null){
            //Convert to the response object
            studentEntities.forEach(studentEntity -> {
                StudentData studentData = EntityToDataConverter.toStudentData(studentEntity);
                students.add(studentData);
            });
        }
        return students;
    }

    @Override
    @Transactional
    public StudentData createStudent(StudentRequest request) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(request.getName());
        studentEntity = studentDao.saveStudent(studentEntity);
        //Convert to the response object and return
        return EntityToDataConverter.toStudentData(studentEntity);
    }

    @Override
    public StudentData getStudentById(Long id) {
        StudentEntity studentEntity = studentDao.getStudentById(id);
        if(studentEntity == null){
            log.error("No student found by id: {}",id);
            throw new NotFound("Student not found");
        }
        return EntityToDataConverter.toStudentData(studentEntity);
    }

    @Override
    public List<StudentData> getAllByName(String name) {
        List<StudentEntity> studentEntities = studentDao.getByName(name);
        if(studentEntities == null || studentEntities.size() ==0){
            log.error("No student found by name: {}",name);
            throw new NotFound("No students are found by name");
        }
        List<StudentData> students = new ArrayList<>();
        studentEntities.forEach(studentEntity -> {
            //Convert to the response object
            StudentData studentData = EntityToDataConverter.toStudentData(studentEntity);
            students.add(studentData);
        });
        return students;
    }

    @Override
    public StudentData updateStudent(StudentRequest request, Long id) {
        StudentEntity studentEntity = studentDao.getStudentById(id);
        if(studentEntity == null){
            log.error("No student found by id: {}",id);
            throw new NotFound("Student not found");
        }
        studentEntity.setName(request.getName());
        studentEntity = studentDao.saveStudent(studentEntity);
        return EntityToDataConverter.toStudentData(studentEntity);
    }

    @Override
    public void deleteStudentById(Long id) {
        StudentEntity studentEntity = studentDao.getStudentById(id);
        if(studentEntity == null){
            log.error("No student found by id: {}",id);
            throw new NotFound("Student not found");
        }
        studentDao.deleteStudentById(id);
    }

    @Override
    @Transactional
    public void deleteStudentByName(String name) {
        List<StudentEntity> studentEntities = studentDao.getByName(name);
        if(studentEntities == null || studentEntities.size() == 0){
            log.error("No student found by name: {}",name);
            throw new NotFound("No students are found by name");
        }
        studentDao.deleteByName(name);
    }
}
