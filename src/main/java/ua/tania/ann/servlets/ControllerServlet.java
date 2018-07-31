package ua.tania.ann.servlets;

import ua.tania.ann.model.dao.ScoreDAO;
import ua.tania.ann.model.dao.StudentDAO;
import ua.tania.ann.model.dao.SubjectDAO;
import ua.tania.ann.model.entities.Score;
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
    private ScoreDAO scoreDAO;

    public void init() {
        studentDAO = new StudentDAO();
        subjectDAO = new SubjectDAO();
        scoreDAO = new ScoreDAO();
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
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateStudent(request, response);
                    break;
                case "/delete":
                    deleteStudent(request, response);
                    break;
                case "/listSubject":
                     listSubject(request, response);
                    break;
                case "/addSubject":
                    insertSubject(request, response);
                    break;
                case "/addScores":
                    showFormForScores(request, response);
                    break;
                case "/insertScore":
                    insertScore(request, response);
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

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentDAO.getStudent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentForm.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);

    }

    private void showFormForScores(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, ClassNotFoundException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ScoreForm.jsp");
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

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("first_name");
        String secondName = request.getParameter("second_name");
        String middleName = request.getParameter("middle_name");
        int kurs = Integer.parseInt( request.getParameter("kurs"));
        String grupa = request.getParameter("grupa");
        String studyForm = request.getParameter("study_form");
        String paymentForm = request.getParameter("payment_form");

        Student student = new Student(id,firstName, secondName, middleName, kurs, grupa, studyForm, paymentForm );
        studentDAO.updateStudent(student);
        response.sendRedirect("list");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));

        Student student = new Student(id);
        studentDAO.deleteStudent(student);
        response.sendRedirect("list");

    }

    private void listSubject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Subject> listSubject = subjectDAO.listAllSubjects();
        request.setAttribute("listSubject", listSubject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SubjectList.jsp");
        dispatcher.forward(request, response);
    }

    private void insertSubject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        String name = request.getParameter("name");

        Subject newSubject = new Subject(name);
        subjectDAO.insertSubject(newSubject);
        response.sendRedirect("listSubject");
    }

    private void insertScore(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {
        int value = Integer.parseInt(request.getParameter("value"));
        int studentId = Integer.parseInt(request.getParameter("id_student"));
        String subjectName = request.getParameter("name_subject");
        Score newScore = new Score(value, studentId, subjectName);
        scoreDAO.insertScore(newScore);
        response.sendRedirect("listScores");
    }
}
