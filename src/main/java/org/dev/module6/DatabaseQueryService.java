package org.dev.module6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DatabaseQueryService {
    public List<MaxProjectCountClient> findMaxProjectsClient() {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        List<MaxProjectCountClient> clients = new ArrayList<>();

        try {

            String sql = new String(Files.readAllBytes(Paths.get("sql/find_max_projects_client.sql")));

            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("project_count");
                clients.add(new MaxProjectCountClient(name, projectCount));
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }
}
