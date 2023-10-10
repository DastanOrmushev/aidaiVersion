package services.impl;

import org.sqlite.SQLiteException;
import services.DbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelperImpl implements DbHelper {
    private final String url = "jdbc:sqlite:D:\\SUBD\\DBBrowser\\storeDb.db";
    @Override
    public PreparedStatement getStatement(String sql) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            PreparedStatement ps = connection.prepareStatement(sql);
            return ps;
        } catch (SQLiteException e) {
            throw new RuntimeException("Произошла ошибка при подключении драйвера -> {}"+e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Произошла ошибка при подключении к БД ->"+e.getMessage());
        } finally {
            if (connection == null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
