package com.crud.simple.controller;

import com.crud.simple.model.request.StudentRequest;
import com.crud.simple.model.response.StudentData;
import com.crud.simple.model.response.StudentListResponse;
import com.crud.simple.servive.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public StudentListResponse getAllStudents(){
        List<StudentData> students = studentService.getAllStudents();
        return StudentListResponse.builder()
                .students(students).build();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public StudentData createStudent(@RequestBody @Valid StudentRequest request){
        StudentData student = studentService.createStudent(request);
        return student;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public StudentData updateStudent(@PathVariable Long id, @RequestBody @Valid StudentRequest request){
        StudentData student = studentService.updateStudent(request,id);
        return student;
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public StudentListResponse getStudentsByName(@PathVariable String name){
        List<StudentData> students = studentService.getAllByName(name);
        return StudentListResponse.builder()
                .students(students).build();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public StudentData getStudentsById(@PathVariable Long id){
        StudentData student = studentService.getStudentById(id);
        return student;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.DELETE)
    public void deleteStudentByName(@PathVariable String name){
        studentService.deleteStudentByName(name);
    }


}
