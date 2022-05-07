package com.crud.simple.repository;

import com.crud.simple.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    List<StudentEntity> findAllByName(String name);

    void deleteAllByName(String name);
}
