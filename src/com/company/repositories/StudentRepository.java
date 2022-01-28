package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Student;
import com.company.repositories.interfaces.IStudentRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StudentRepository implements IStudentRepository
{
    private final IDB db;

    public StudentRepository(IDB db)
    {
        this.db = db;
    }

    @Override
    public boolean createStudent(Student student)
    {
        Connection connection = null;

        try
        {
            connection = db.getConnection();
            String sql = "INSERT INTO users(name,surname,gender) VALUES (?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, student.getName());
            st.setString(2, student.getSurname());
            st.setString(3, student.getGroup());

            st.execute();
            return true;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Student getStudent(int id)
    {
        Connection connection = null;

        try
        {
            connection = db.getConnection();
            String sql = "SELECT id,name,surname,gender FROM users WHERE id=?";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next())
            {
                Student student = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("group"));

                return student;
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Student> getAllStudents()
    {
        Connection connection = null;

        try
        {
            connection = db.getConnection();
            String sql = "SELECT id,name,surname,gender FROM users";
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Student> students = new LinkedList<>();

            while (rs.next())
            {
                Student student = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("group"));

                students.add(student);
            }

            return students;
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        }

        return null;
    }
}
