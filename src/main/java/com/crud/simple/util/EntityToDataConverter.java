package com.crud.simple.util;

import com.crud.simple.entity.StudentEntity;
import com.crud.simple.model.response.StudentData;

public class EntityToDataConverter {
    public static StudentData toStudentData(StudentEntity studentEntity){
        return StudentData.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .build();
    }
}
