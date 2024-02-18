package net.javaguides.springbootrestapi.controller;

import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1, "Rupinder", "Singh");
        return student;
    }

    @GetMapping("student-list")
    public List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();
        Student student = new Student(1, "Rupinder", "Singh");
        Student student2 = new Student(2, "Prabhat", "Gupta");
        students.add(student);
        students.add(student2);
        return students;
    }

    // Spring Boot Rest API with path Variable
    // {id} - URI template variable
    // http://localhost:8080/student/1
    @GetMapping("student/{id}/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable int id,@PathVariable String firstName,
                                       @PathVariable String lastName) {
        return new Student(id, firstName, lastName);
    }
} 
