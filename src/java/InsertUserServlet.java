/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Viral
 */
public class InsertUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          User u = new User();
          u.name = request.getParameter("txtname");
          u.gender=request.getParameter("gender");
          u.username=request.getParameter("txtusername");
          u.password=request.getParameter("txtpassword");
          ServletContext context = getServletContext();
          String driver = context.getInitParameter("Database Driver");
          String url = context.getInitParameter("Database Url");
          DatabaseHelper dbhelper = new DatabaseHelper(driver, url);
          int status = dbhelper.insertRecord(u);
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertUserServlet at " + request.getContextPath() + "</h1>");
            out.println(u.name);
            out.println(u.gender);
            out.println(u.username);
            out.println(u.password);
            out.println(driver);
            out.println(url);
            out.println(status);
            out.println("</body>");
            out.println("</html>");
        }
    }
}