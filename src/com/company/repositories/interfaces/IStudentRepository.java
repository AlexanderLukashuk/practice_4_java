package com.company.repositories.interfaces;

import com.company.entities.Student;

import java.util.List;

public interface IStudentRepository
{
    boolean createStudent(Student user);
    Student getStudent(int id);
    List<Student> getAllStudents();
}
