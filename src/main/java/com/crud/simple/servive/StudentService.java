package com.crud.simple.servive;

import com.crud.simple.model.request.StudentRequest;
import com.crud.simple.model.response.StudentData;

import java.util.List;

public interface StudentService {
    /**
     * Get all the students that is in the db else return an empty array list
     * @return
     */
    List<StudentData> getAllStudents();

    /**
     * Create student by the given name
     * @param request
     * @return
     */
    StudentData createStudent(StudentRequest request);

    /**
     * Get student by the id db else throw not found exception
     * @param id
     * @return
     */
    StudentData getStudentById(Long id);

    /**
     * Get all the students by the given name
     * If none is found throw not found exception
     * @param name
     * @return
     */
    List<StudentData> getAllByName(String name);

    /**
     * Find a student by id. If not found throw not found exception
     * else update the name
     * @param request
     * @param id
     * @return
     */
    StudentData updateStudent(StudentRequest request, Long id);

    /**
     * Find a student by the given id. If not found throw exception
     * else delete id from db
     * @param id
     */
    void deleteStudentById(Long id);

    /**
     * Find all the students by the given name. If none is found throw exception
     * else delete all by the given name
     * @param name
     */
    void deleteStudentByName(String name);
}
