
package br.edu.ifsp.regescweb.sevlets;

import br.edu.ifsp.regescweb.dao.StudentDAO;
import br.edu.ifsp.regescweb.models.Student;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/students/new")
public class StudentsNewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            
            Student student = new Student(name, age);
            
            StudentDAO dao = new StudentDAO();
            dao.insert(student);
            
            req.setAttribute("student", student);
            RequestDispatcher disp = req.getRequestDispatcher("show.jsp");
            disp.forward(req, resp);
        } catch (ClassNotFoundException ex) {
            // localhost:8084/regescweb/students/error.jsp
            resp.sendRedirect("error.jsp");
            Logger.getLogger(StudentsNewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            resp.sendRedirect("error.jsp");
            Logger.getLogger(StudentsNewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
