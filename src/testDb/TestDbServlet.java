package testDb;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestDbServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //THIS IS NOT DONE YET I STILL CAN'T FIGURE OUT HOW TO RUN THIS ON INTELLIJ

        //setup connection variable
        String user = "daniel";
        String pass = "admin";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?publicKeyRetrieval=true&useSSL=false";
        String driver = "com.mysql.jdbc.Driver";

        try{
            PrintWriter out = response.getWriter();
            out.println("Connecting to database: "+ jdbcUrl);
            out.println("\nTEST");
            Class.forName(driver);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("CLOSED");
            out.println("Success");
            out.println("hi!");
            myConn.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
