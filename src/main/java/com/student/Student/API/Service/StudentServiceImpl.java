package com.student.Student.API.Service;

import com.student.Student.API.Entity.Student;
import com.student.Student.API.Exception.StudentNotFoundException;
import com.student.Student.API.Repository.StudentRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;


    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }


    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (optionalStudent.isPresent()) {
            student.setStudent_id(id);
            return studentRepo.save(student);
        } else {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
    }
    @Override
    public Student getStudentById(int id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
    }



    @Override
    public void deleteStudent(int id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        } else {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
    }
}
