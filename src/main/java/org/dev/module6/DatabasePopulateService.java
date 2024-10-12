package org.dev.module6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database database = Database.getInstance();

        try {

            String sql = new String(Files.readAllBytes(Paths.get("sql/populate_db.sql")));


            database.executeUpdate(sql);

            System.out.println("Таблиці бази даних успішно наповнені.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
