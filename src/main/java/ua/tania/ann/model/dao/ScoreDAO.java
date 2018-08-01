package ua.tania.ann.model.dao;

import ua.tania.ann.model.entities.Score;
import ua.tania.ann.model.entities.Student;
import ua.tania.ann.utils.MySqlConnUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Таня on 31.07.2018.
 */
public class ScoreDAO {
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

    public boolean insertScore(Score score) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO score (id_student, name_subject, value)" +
                " VALUES (?, ?, ?)";
        connectToDatabase();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, score.getStudentId());
        statement.setString(2, score.getSubjectName());
        statement.setInt(3, score.getValue());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnectFromDatabase();
        return rowInserted;
    }

    public List<Student>  listAllScores() throws SQLException, ClassNotFoundException {
         List<Student> listStudentWithScores = new ArrayList<>();

        String sql = "SELECT* FROM score, student WHERE score.id_student = student.id";

        connectToDatabase();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int idStudent = resultSet.getInt("id_student");
            String subjectName = resultSet.getString("name_subject");
            int value = resultSet.getInt("value");
            String firstName = resultSet.getString("first_name");
            String secondName = resultSet.getString("second_name");
            String middleName = resultSet.getString("middle_name");
            Student student = new Student(idStudent, firstName, secondName, middleName);
            student.getFinalResult().put(subjectName, value);
            listStudentWithScores.add(student);
        }

        resultSet.close();
        statement.close();

        disconnectFromDatabase();

        return listStudentWithScores;
    }

    public boolean deleteScore(Score score) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM score where id = ?";

        connectToDatabase();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, score.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnectFromDatabase();
        return rowDeleted;
    }

 /*   public boolean updateScore(Score score) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE score SET first_name = ?, second_name = ?, middle_name = ?, " +
                "kurs = ?, grupa = ?, study_form = ?, payment_form = ?";
        sql += " WHERE id = ?";
        connectToDatabase();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, score.getFirstName());
        statement.setString(2, score.getSecondName());
        statement.setString(3, score.getMiddleName());
        statement.setInt(4, score.getKurs());
        statement.setString(5, score.getGroup());
        statement.setString(6, score.getStudyForm());
        statement.setString(7, score.getPaymentForm());
        statement.setInt(8, score.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnectFromDatabase();
        return rowUpdated;
    }*/

/*    public Score getScore(int id) throws SQLException, ClassNotFoundException {
        Score score = null;
        String sql = "SELECT * FROM score WHERE id = ?";

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
            score = new Score(id, firstName, secondName, middleName, kurs, grupa, studyForm, paymentForm );
        }

        resultSet.close();
        statement.close();

        return score;
    }*/
}
