package com.student.Student.API.Service;

import com.student.Student.API.Entity.Student;
import javassist.NotFoundException;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void deleteStudent(int id);
    Student createStudent(Student student);
    Student updateStudent(int id, Student student);

}
