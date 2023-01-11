package com.example.studentlistfragments;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    ArrayList<Student> studentList=new ArrayList<>();

    public StudentService() {
    }

    private boolean isEmpty() {
        return studentList.size() == 0;
    }

    public List<Student> getAllStudent() {
        return studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }
    public Student getStudentById(long id) {
        for(Student student:studentList){
            if(student.getId()==id)
                return student;
        }
        return null;
    }
    public Student getStudent(Student student){
        return getStudentById(student.getId());
    }
    public void updateStudent(Student student) {
        deleteStudent(student);
        studentList.add(student);
    }
    public void deleteStudent(Student student) {
        studentList.remove(getStudentById(student.getId()));
    }
    public void deleteStudentById(long id) {
        studentList.remove(getStudentById(id));
    }

}
