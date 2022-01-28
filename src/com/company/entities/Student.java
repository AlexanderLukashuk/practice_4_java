package com.company.entities;

public class Student
{
    private int id;
    private String name;
    private String surname;
    private String group;

    public Student() {}

    public Student(String name, String surname, String group)
    {
        setName(name);
        setSurname(surname);
        setGroup(group);
    }

    public Student(int id, String name, String surname, String group)
    {
        setId(id);
        setName(name);
        setSurname(surname);
        setGroup(group);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getGroup()
    {
        return group;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name +
                ", surname='" + surname +
                ", gender=" + group +
                '}';
    }

}
