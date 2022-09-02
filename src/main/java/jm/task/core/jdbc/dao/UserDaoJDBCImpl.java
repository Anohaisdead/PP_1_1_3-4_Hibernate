package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String myTableName = "CREATE TABLE IF NOT EXISTS Users ("
                + "`idUsers` INT NOT NULL AUTO_INCREMENT,"
                + "`Name` VARCHAR(45) NOT NULL,"
                + "`LastName` VARCHAR(45) NOT NULL,"
                + "`Age` INT NULL,"
                + "PRIMARY KEY (`idUsers`))";
        try (Statement st = Util.getConnection().createStatement()){
            st.executeUpdate(myTableName);
        } catch (SQLException e ) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate("DROP TABLE if exists USERS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "insert into users(name, lastName, age)" +
                "values (?, ?, ?)";

        try ( PreparedStatement ps = Util.getConnection().prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate("delete from users where idUsers = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (
                PreparedStatement ps = Util.getConnection().prepareStatement("select * from users");
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge(rs.getByte(4));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.executeUpdate("truncate TABLE USERS");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}