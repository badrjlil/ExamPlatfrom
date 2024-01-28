package main;


import java.sql.Connection;
import java.sql.DriverManager;

public class connection {

    public static Connection connectDB() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/Java_Project";
        String user = "postgres", password = "123456";
        return DriverManager.getConnection(url, user, password);
    }

}
