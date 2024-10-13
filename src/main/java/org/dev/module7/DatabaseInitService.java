package org.dev.module7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;

public class DatabaseInitService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();

        try {

            String sql = new String(Files.readAllBytes(Paths.get("sql/init_db.sql")));


            database.executeUpdate(sql);

            System.out.println("База даних успішно ініціалізована.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
