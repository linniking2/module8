package org.dev.module7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private String readFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + filePath, e);
        }
    }

    public List<Project> findLongestProject() {
        String sql = readFile("sql/find_longest_project.sql");
        List<Project> projects = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int duration = rs.getInt("project_duration_months");
                projects.add(new Project(id, duration));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projects;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String sql = readFile("sql/find_max_projects_client.sql");
        List<MaxProjectCountClient> clients = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                int projectCount = rs.getInt("project_count");
                clients.add(new MaxProjectCountClient(name, projectCount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<Worker> findMaxSalaryWorker() {
        String sql = readFile("sql/find_max_salary_worker.sql");
        List<Worker> workers = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                workers.add(new Worker(name, salary));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workers;
    }

    public List<WorkerAge> findYoungestEldestWorkers() {
        String sql = readFile("sql/find_youngest_eldest_workers.sql");
        List<WorkerAge> workers = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String type = rs.getString("type");
                String name = rs.getString("name");
                java.sql.Date birthday = rs.getDate("birthday");
                workers.add(new WorkerAge(type, name, birthday));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workers;
    }

    public List<ProjectPrice> printProjectPrices() {
        String sql = readFile("sql/print_project_prices.sql");
        List<ProjectPrice> projectPrices = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                projectPrices.add(new ProjectPrice(id, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectPrices;
    }
}
