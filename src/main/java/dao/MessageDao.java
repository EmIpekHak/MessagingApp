package dao;

import model.Message;

import java.sql.*;
import java.util.List;

public class MessageDao implements IDao<Message> {
    private Connection con;

    public MessageDao() throws SQLException, ClassNotFoundException {
        this.con = MysqlDatabaseConnection.getConnection("jdbc:mysql://localhost:3306/messagingapp", "root", "");
    }

    @Override
    public Message findById(Integer id) {
        return null;
    }

    @Override
    public List<Message> findAll() {
        return List.of();
    }

    @Override
    public void save(Message o) {
        String sql = "INSERT INTO message (message, date, fromUser, toUser) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, o.getMessage());
            ps.setString(2, o.getDate().toString());
            ps.setString(3, Integer.toString(o.getSenderId()));
            ps.setString(4, Integer.toString(o.getReceiverId()));

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating message failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    o.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating message failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Message o) {

    }

    @Override
    public void delete(Integer id) {

    }
}
