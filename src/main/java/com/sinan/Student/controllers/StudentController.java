package com.sinan.Student.controllers;

import com.sinan.Student.models.Student;
import com.sinan.Student.repositories.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> list () {
        return studentRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Student get (@PathVariable Long id) {
        return studentRepository.getOne(id);
    }

    @PostMapping
    public Student create (@RequestBody Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Student update (@PathVariable Long id , @RequestBody Student student) {
        Student existingStudent = studentRepository.getOne(id);
        BeanUtils.copyProperties(student,existingStudent,"student_id");
        return studentRepository.saveAndFlush(existingStudent);
    }

}
