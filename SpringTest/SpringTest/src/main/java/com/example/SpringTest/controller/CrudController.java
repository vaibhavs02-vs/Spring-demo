package com.example.SpringTest.controller;

import com.example.SpringTest.model.Student;
import com.example.SpringTest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
@Component
public class CrudController {

    @Autowired
    StudentRepository student;

    @CacheEvict(value = "students", allEntries = true)
    @PostMapping("/insert")
    public String insertStudent(@RequestBody Student s){
        try{
            student.save(s);
            return "Data is Inserted";
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student s){
        try{
            student.save(s);
            return "Data is Updated";
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    @PatchMapping("/patch")
    public String patchStudent(@RequestBody Student s){
        try{
            student.save(s);
            return "Data is Patched";
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete", params = "id")
    public String deleteStudent(@RequestParam("id") String id){
        try{
            student.deleteById(id);
            return "Data is Deleted";
        }catch (Exception e){
            return (e.getMessage());
        }
    }

}
