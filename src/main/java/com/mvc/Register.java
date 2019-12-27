/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc;

import com.mysql.jdbc.StringUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.internal.joptsimple.internal.Strings;

public class Register extends HttpServlet {
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String phone_number = request.getParameter("mobile");
        String first_name = request.getParameter("firstname");
        String last_name = request.getParameter("lastname");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/my_app_database", "root", "");
            String query = "insert into user values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, phone_number);
            ps.setString(2, first_name);
            ps.setString(3, last_name);
            if(StringUtils.isEmptyOrWhitespaceOnly(birthday)) {
                ps.setNull(4, Types.DATE);
            } else {
                ps.setString(4, birthday);
            }
            if(StringUtils.isEmptyOrWhitespaceOnly(gender)) {
                ps.setNull(5, Types.VARCHAR);
            } else {
                ps.setString(5, gender);
            }
            ps.setString(6, email);

            ps.executeUpdate();
            conn.commit();
            ps.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }
 
}