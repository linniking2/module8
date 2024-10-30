package org.dev.module8;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 50;
    private final Connection connection;

    public ClientService() {
        this.connection = Database.getInstance().getConnection();
    }

    public long create(String name) throws SQLException {
        validateName(name);
        String sql = "INSERT INTO client (name) VALUES (?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        throw new SQLException("Failed to create client.");
    }

    public String getById(long id) throws SQLException {
        String sql = "SELECT name FROM client WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("name");
                }
            }
        }
        throw new SQLException("Client with id " + id + " not found.");
    }

    public void setName(long id, String name) throws SQLException {
        validateName(name);
        String sql = "UPDATE client SET name = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setLong(2, id);

            if (ps.executeUpdate() == 0) {
                throw new SQLException("Client with id " + id + " not found.");
            }
        }
    }

    public void deleteById(long id) throws SQLException {
        String sql = "DELETE FROM client WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);

            if (ps.executeUpdate() == 0) {
                throw new SQLException("Client with id " + id + " not found.");
            }
        }
    }

    public List<Client> listAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT id, name FROM client";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                clients.add(new Client(rs.getLong("id"), rs.getString("name")));
            }
        }
        return clients;
    }

    private void validateName(String name) {
        if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Client name must be between " + MIN_NAME_LENGTH +
                    " and " + MAX_NAME_LENGTH + " characters.");
        }
    }
}
