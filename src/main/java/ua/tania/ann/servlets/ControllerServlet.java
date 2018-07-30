package ua.tania.ann.servlets;

import ua.tania.ann.model.dao.StudentDAO;
import ua.tania.ann.model.dao.SubjectDAO;
import ua.tania.ann.model.entities.Student;
import ua.tania.ann.model.entities.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Таня on 25.07.2018.
 */
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;
    private SubjectDAO subjectDAO;

    public void init() {
        studentDAO = new StudentDAO();
        subjectDAO = new SubjectDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertStudent(request, response);
                    break;
                case "/listSubject":
                     listSubject(request, response);
                    break;
                default:
                    listStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Student> listStudent = studentDAO.listAllStudents();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        String firstName = request.getParameter("first_name");
        String secondName = request.getParameter("second_name");
        String middleName = request.getParameter("middle_name");
        int kurs = Integer.parseInt( request.getParameter("kurs"));
        String grupa = request.getParameter("grupa");
        String studyForm = request.getParameter("study_form");
        String paymentForm = request.getParameter("payment_form");

        Student newStudent = new Student(firstName, secondName, middleName, kurs, grupa, studyForm, paymentForm );
        studentDAO.insertStudent(newStudent);
        response.sendRedirect("list");
    }

    private void listSubject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Subject> listSubject = subjectDAO.listAllSubjects();
        request.setAttribute("listSubject", listSubject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SubjectList.jsp");
        dispatcher.forward(request, response);
    }
}
