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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                case "/listScores" :
                    listScores(request, response);
                    break;
                case "/filter" :
                    listStudentWithFilter(request, response);
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

    private void listStudentWithFilter(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        List<Student> listStudent;
        String kurs = request.getParameter("selectedKurs");
        String grupa = request.getParameter("selectedGroup");
        String studyForm = request.getParameter("selectedStudyForm");
        String paymentForm = request.getParameter("selectedPaymentForm");
        if (!kurs.equals("all"))
            listStudent = studentDAO.getAllStudentByKurs(Integer.parseInt(kurs));
        else if (!grupa.equals("all"))
            listStudent = studentDAO.getAllStudentByGroup(grupa);
        else if (!studyForm.equals("all"))
            listStudent = studentDAO.getAllStudentByStudyForm(studyForm);
        else if (!paymentForm.equals("all"))
            listStudent = studentDAO.getAllStudentByPaymentForm(paymentForm);
        else listStudent = studentDAO.listAllStudents();
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
        Student existingStudent = studentDAO.getStudentById(id);
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
        int kurs = Integer.parseInt( request.getParameter("selectedKurs"));
        String grupa = request.getParameter("selectedGroup");
        String studyForm = request.getParameter("selectedStudyForm");
        String paymentForm = request.getParameter("selectedPaymentForm");

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
        int kurs = Integer.parseInt( request.getParameter("selectedKurs"));
        String grupa = request.getParameter("selectedGroup");
        String studyForm = request.getParameter("selectedStudyForm");
        String paymentForm = request.getParameter("selectedPaymentForm");

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

    private void listScores(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ClassNotFoundException {
        Map<Student, Map<Subject, Score>> mapScores = scoreDAO.listAllScores();
        request.setAttribute("mapScore", mapScores);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ScoreList.jsp");
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
        String subjectName = request.getParameter("selectedSubject");
        Score newScore = new Score(value, studentId, subjectName);
        scoreDAO.insertScore(newScore);
        response.sendRedirect("listScores");
    }
}
