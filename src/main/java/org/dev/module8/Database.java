package org.dev.module8;

import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            String url = "jdbc:h2:file:D:/go it/dev modules/module8";
            this.connection = DriverManager.getConnection(url);

            Flyway flyway = Flyway
                    .configure()
                    .dataSource(url, null, null)
                    .load();

            flyway.migrate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
