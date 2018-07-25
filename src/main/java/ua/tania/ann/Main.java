package ua.tania.ann;

import ua.tania.ann.utils.MySqlConnUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Таня on 25.07.2018.
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            Connection connection = MySqlConnUtils.getMySQLConnection();
    }
}
