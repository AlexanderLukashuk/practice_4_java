package com.company;

import com.company.controllers.StudentController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.StudentRepository;
import com.company.repositories.interfaces.IStudentRepository;

public class Main
{

    public static void main(String[] args)
    {
        IDB db = new PostgresDB();
        IStudentRepository repo = new StudentRepository(db);
        StudentController controller = new StudentController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}
