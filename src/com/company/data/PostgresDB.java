package com.company.data;

import com.company.data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IDB
{
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException
    {
        String connectionUrl = "jdbc:postgresql://localhost:5432/mydb";
        try
        {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(connectionUrl, "postgres", "0000");

            return connection;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}
