
package br.edu.ifsp.regescweb.sevlets;

import br.edu.ifsp.regescweb.dao.StudentDAO;
import br.edu.ifsp.regescweb.models.Student;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/students")
public class StudentsAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // recuperar uma lista com todos os estudantes no BD
            StudentDAO dao = new StudentDAO();
            ArrayList<Student> list = dao.findAll();
            
            req.setAttribute("list", list);
            RequestDispatcher disp = req.getRequestDispatcher("students/index.jsp");
            disp.forward(req, resp);
            
        } catch (ClassNotFoundException ex) {
            // localhost/regescweb/students/error.jsp
            resp.sendRedirect("students/error.jsp");
            Logger.getLogger(StudentsNewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            resp.sendRedirect("students/error.jsp");
            Logger.getLogger(StudentsNewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // redirecionar/dispachar esta lista para a página index.jsp
    }
    
}
