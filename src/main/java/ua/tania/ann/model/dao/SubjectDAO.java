package ua.tania.ann.model.dao;

import ua.tania.ann.model.entities.Subject;
import ua.tania.ann.utils.MySqlConnUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Таня on 30.07.2018.
 */
public class SubjectDAO {
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

    public boolean insertSubject(Subject subject) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO subject (name)" + " VALUES (?)";
        connectToDatabase();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, subject.getName());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnectFromDatabase();
        return rowInserted;
    }

    public List<Subject> listAllSubjects() throws SQLException, ClassNotFoundException {
        List<Subject> listSubjects = new ArrayList<>();

        String sql = "SELECT* FROM subject";

        connectToDatabase();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            Subject subject = new Subject(id, name);
            listSubjects.add(subject);
        }

        resultSet.close();
        statement.close();

        disconnectFromDatabase();

        return listSubjects;
    }
}
