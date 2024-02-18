package net.javaguides.springbootrestapi.controller;

import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // Spring boot Rest API with Request PARAM
    // http://localhost:8080/student/query?id=1&firstname="first"&lastName="second"
    @GetMapping("student/query")
    public Student studentRequestVariable(@RequestParam int id,@RequestParam String firstname,@RequestParam String lastName){
        return new Student(id, firstname, lastName);
    }

    // Spring boot REST API that handles HTTP POST Request
    // @PostMapping and @RequestBody
    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return new Student(student.getId(), student.getFirstname(), student.getLastname());
    }


    @PutMapping("student/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(studentId);
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return new Student(studentId, student.getFirstname(), student.getLastname());
    }

    @DeleteMapping("student/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ("Successfully Deleted => "+(new Student(studentId, "dummyName", "dummyLastName")));
    }
}
