package com.company.controllers;

import com.company.entities.Student;
import com.company.repositories.interfaces.IStudentRepository;

import java.util.List;

public class StudentController
{
    private final IStudentRepository repository;


    public StudentController(IStudentRepository repository)
    {
        this.repository = repository;
    }

    public String createStudent(String name, String surname, String group)
    {
        Student student = new Student(name, surname, group);

        boolean created = repository.createStudent(student);

        return (created ? "Student was created" : "Student creation was failed");
    }

    public String getStudent(int id)
    {
        Student student = repository.getStudent(id);

        return (student == null ? "Student was not found" : student.toString());
    }

    public String getAllStudents()
    {
        List<Student> students = repository.getAllStudents();

        return students.toString();
    }
}
