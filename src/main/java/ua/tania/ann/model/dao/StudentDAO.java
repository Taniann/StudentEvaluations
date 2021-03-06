package ua.tania.ann.model.dao;

import ua.tania.ann.model.entities.Student;
import ua.tania.ann.utils.MySqlConnUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Таня on 25.07.2018.
 */
public class StudentDAO {
    private Connection jdbcConnection;

    protected void connectToDatabase() throws SQLException, ClassNotFoundException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = MySqlConnUtils.getMySQLConnection();
        }
    }

    protected void disconnectFromDatabase() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertStudent(Student student) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO student (first_name, second_name, middle_name, kurs, grupa, study_form, payment_form)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        connectToDatabase();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, student.getFirstName());
        statement.setString(2, student.getSecondName());
        statement.setString(3, student.getMiddleName());
        statement.setInt(4, student.getKurs());
        statement.setString(5, student.getGroup());
        statement.setString(6, student.getStudyForm());
        statement.setString(7, student.getPaymentForm());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnectFromDatabase();
        return rowInserted;
    }

    public List<Student> listAllStudents() throws SQLException, ClassNotFoundException {
        List<Student> listStudents = new ArrayList<>();

        String sql = "SELECT* FROM student";

        connectToDatabase();

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
            listStudents.add(student);
        }

        resultSet.close();
        statement.close();

        disconnectFromDatabase();

        return listStudents;
    }

    public boolean deleteStudent(Student student) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM student where id = ?";

        connectToDatabase();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, student.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnectFromDatabase();
        return rowDeleted;
    }

    public boolean updateStudent(Student student) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE student SET first_name = ?, second_name = ?, middle_name = ?, " +
                "kurs = ?, grupa = ?, study_form = ?, payment_form = ?";
        sql += " WHERE id = ?";
        connectToDatabase();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, student.getFirstName());
        statement.setString(2, student.getSecondName());
        statement.setString(3, student.getMiddleName());
        statement.setInt(4, student.getKurs());
        statement.setString(5, student.getGroup());
        statement.setString(6, student.getStudyForm());
        statement.setString(7, student.getPaymentForm());
        statement.setInt(8, student.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnectFromDatabase();
        return rowUpdated;
    }

    public Student getStudentById(int id) throws SQLException, ClassNotFoundException {
        Student student = null;
        String sql = "SELECT * FROM student WHERE id = ?";

        connectToDatabase();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();


        if (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String secondName = resultSet.getString("second_name");
            String middleName = resultSet.getString("middle_name");
            int kurs = resultSet.getInt("kurs");
            String grupa = resultSet.getString("grupa");
            String studyForm = resultSet.getString("study_form");
            String paymentForm = resultSet.getString("payment_form");
            student = new Student(id, firstName, secondName, middleName, kurs, grupa, studyForm, paymentForm );
        }

        resultSet.close();
        statement.close();

        return student;
    }

    public List<Student> getAllStudentByKurs(int kurs) throws SQLException, ClassNotFoundException {
        List<Student> listStudents = new ArrayList<>();
        String sql = "SELECT* FROM student WHERE kurs = ?";

        connectToDatabase();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, kurs);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String secondName = resultSet.getString("second_name");
            String middleName = resultSet.getString("middle_name");
            String grupa = resultSet.getString("grupa");
            String studyForm = resultSet.getString("study_form");
            String paymentForm = resultSet.getString("payment_form");
            Student student = new Student(id, firstName, secondName, middleName, kurs, grupa, studyForm, paymentForm );
            listStudents.add(student);
        }

        resultSet.close();
        statement.close();

        return listStudents;
    }

    public List<Student> getAllStudentByGroup(String group) throws SQLException, ClassNotFoundException {
        List<Student> listStudents = new ArrayList<>();
        String sql = "SELECT* FROM student WHERE grupa = ?";

        connectToDatabase();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, group);

        ResultSet resultSet = statement.executeQuery();

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
            listStudents.add(student);
        }

        resultSet.close();
        statement.close();

        return listStudents;
    }

    public List<Student> getAllStudentByStudyForm(String studyForm) throws SQLException, ClassNotFoundException {
        List<Student> listStudents = new ArrayList<>();
        String sql = "SELECT* FROM student WHERE study_form = ?";

        connectToDatabase();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, studyForm);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String secondName = resultSet.getString("second_name");
            String middleName = resultSet.getString("middle_name");
            int kurs = resultSet.getInt("kurs");
            String grupa = resultSet.getString("grupa");
            studyForm = resultSet.getString("study_form");
            String paymentForm = resultSet.getString("payment_form");
            Student student = new Student(id, firstName, secondName, middleName, kurs, grupa, studyForm, paymentForm );
            listStudents.add(student);
        }

        resultSet.close();
        statement.close();

        return listStudents;
    }

    public List<Student> getAllStudentByPaymentForm(String paymentForm) throws SQLException, ClassNotFoundException {
        List<Student> listStudents = new ArrayList<>();
        String sql = "SELECT* FROM student WHERE payment_form = ?";

        connectToDatabase();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, paymentForm);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String secondName = resultSet.getString("second_name");
            String middleName = resultSet.getString("middle_name");
            int kurs = resultSet.getInt("kurs");
            String grupa = resultSet.getString("grupa");
            String studyForm = resultSet.getString("study_form");
            paymentForm = resultSet.getString("payment_form");
            Student student = new Student(id, firstName, secondName, middleName, kurs, grupa, studyForm, paymentForm );
            listStudents.add(student);
        }

        resultSet.close();
        statement.close();

        return listStudents;
    }
}
