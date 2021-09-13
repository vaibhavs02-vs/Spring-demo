package com.example.SpringTest.repository;

import com.example.SpringTest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findByFname(String fname);
    List<Student> findAllByFnameAndLname(String fname, String lname);
}
