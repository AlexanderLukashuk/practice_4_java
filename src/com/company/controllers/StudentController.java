package com.company.controllers;

import com.company.entities.Student;
import com.company.repositories.interfaces.IStudentRepository;

public class StudentController
{
    private final IStudentRepository repository;


    public StudentController(IStudentRepository repository)
    {
        this.repository = repository;
    }

    public String creatStudent(String name, String surname, String group)
    {
        Student student = new Student(name, surname, group);

        boolean created = repository.createStudent(student);

        return (created ? "Student was created" : "Student creation was failed");
    }
}
