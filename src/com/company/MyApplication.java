package com.company;

import com.company.controllers.StudentController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication
{
    private final StudentController controller;
    private final Scanner scanner;

    public MyApplication(StudentController controller)
    {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start()
    {
        while (true)
        {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all users");
            System.out.println("2. Get user by id");
            System.out.println("3. Create user");
            System.out.println("0. Exit");
            System.out.println();

            try
            {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1)
                {
                    getAllStudentsMenu();
                }
                else if (option == 2)
                {
                    getStudentByIdMenu();
                }
                else if (option == 3)
                {
                    createStudentMenu();
                }
                else if (option == 0)
                {
                    break;
                }
                else
                {
                    System.out.print("Incorrect option entered. Try again");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Input must be integer");
                scanner.nextLine();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");
        }
    }

    public void getAllStudentsMenu()
    {
        String response = controller.getAllStudents();
        System.out.println(response);
    }

    public void getStudentByIdMenu()
    {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getStudent(id);
        System.out.println(response);
    }

    public void createStudentMenu()
    {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter group");
        String group = scanner.next();

        String response = controller.createStudent(name, surname, group);
        System.out.println(response);
    }
}
