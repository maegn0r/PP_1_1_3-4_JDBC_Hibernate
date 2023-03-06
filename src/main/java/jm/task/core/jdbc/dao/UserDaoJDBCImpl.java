//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//
//    public UserDaoJDBCImpl() {
//    }
//
//    public void createUsersTable() {
//        String createUsersTable = """
//                CREATE TABLE if not exists users (
//                id bigint NOT NULL AUTO_INCREMENT,
//                name varchar(100),
//                lastName varchar(150),
//                age tinyint,
//                PRIMARY KEY (id)
//                );
//                """;
//        try (Connection connection = Util.getConnection();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(createUsersTable);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        String dropUsersTable = "DROP TABLE if exists USERS;";
//        try (Connection connection = Util.getConnection();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(dropUsersTable);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String saveUser = "INSERT into users (name,lastName,age) VALUES (?,?,?)";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement ps = connection.prepareStatement(saveUser)) {
//            ps.setString(1, name);
//            ps.setString(2, lastName);
//            ps.setByte(3, age);
//            ps.executeUpdate();
//            System.out.println("User c именем - " + name + " добавлен в базу данных");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        String removeUser = "DELETE FROM users WHERE id=?";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement ps = connection.prepareStatement(removeUser)) {
//            ps.setLong(1, id);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        String selectAll = "SELECT * FROM users";
//        List<User> result = new ArrayList<>();
//        try (Connection connection = Util.getConnection();
//             PreparedStatement ps = connection.prepareStatement(selectAll);
//             ResultSet rs = ps.executeQuery()) {
//            if (rs != null) {
//                while (rs.next()) {
//                    User user = new User(rs.getString("name"), rs.getString("lastName"), rs.getByte("age"));
//                    user.setId(rs.getLong("id"));
//                    result.add(user);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public void cleanUsersTable() {
//        String removeUser = "DELETE FROM users";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement ps = connection.prepareStatement(removeUser)) {
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
