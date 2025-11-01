// Interface: StudentService.java
package com.example.studentmanagementsystem.service;
import com.example.studentmanagementsystem.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    void deleteStudentById(Long id);
}