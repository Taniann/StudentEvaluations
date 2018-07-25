package ua.tania.ann.model.dao;

import ua.tania.ann.model.entities.Student;
import ua.tania.ann.utils.MySqlConnUtils;

import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Таня on 25.07.2018.
 */
public class StudentDAO {
    private Connection jdbcConnection;

    protected void connect() throws SQLException, ClassNotFoundException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = MySqlConnUtils.getMySQLConnection();
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertStudent(Student student) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO student (first_name, second_name, middle_name, kurse, grupa, study_form, payment_form)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(2, student.getFirstName());
        statement.setString(3, student.getSecondName());
        statement.setString(4, student.getMiddleName());
        statement.setInt(5, student.getKurs());
        statement.setString(6, student.getGroup());
        statement.setString(7, student.getStudyForm());
        statement.setString(8, student.getPaymentForm());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Student> listAllStudents() throws SQLException, ClassNotFoundException {
        List<Student> listStudent = new ArrayList<>();

        String sql = "SELECT * FROM student_evaluations";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String secondName = resultSet.getString("second_name");
            String middleName = resultSet.getString("middle_name");
            int kurs = resultSet.getInt("kurs");
            String grupa = resultSet.getString("grupa");
            String studyForm = resultSet.getString("study_form");
            String paymentForm = resultSet.getString("payment_form");
            Student student = new Student(id, firstName, secondName, middleName, kurs, grupa, studyForm, paymentForm );
            listStudent.add(student);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listStudent;
    }
}
