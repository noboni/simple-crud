package com.crud.simple.servive;

import com.crud.simple.model.request.StudentRequest;
import com.crud.simple.model.response.StudentData;

import java.util.List;

public interface StudentService {
    List<StudentData> getAllStudents();

    StudentData createStudent(StudentRequest request);

    StudentData getStudentById(Long id);

    List<StudentData> getAllByName(String name);

    StudentData updateStudent(StudentRequest request, Long id);

    void deleteStudentById(Long id);

    void deleteStudentByName(String name);
}
