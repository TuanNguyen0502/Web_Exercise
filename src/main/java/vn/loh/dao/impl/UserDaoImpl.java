package vn.loh.dao.impl;

import vn.loh.configs.DBConnectMySQL;
import vn.loh.dao.IUserDao;
import vn.loh.models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM users";

        List<UserModel> users = new ArrayList<>();
        try {
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setImage(rs.getString("image"));
                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public UserModel findById(int id) {
        return null;
    }

    @Override
    public UserModel findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username=?";

        try {
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next())
            {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setImage(rs.getString("image"));
                user.setRoleid(rs.getInt("roleid"));
                user.setCreatedate(rs.getDate("createdate"));
                user.setPhone(rs.getString("phone"));
                return user;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void insert(UserModel userModel) {
        String sql = "INSERT INTO users(email, username, fullname, password, image, roleid, phone, createdate) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userModel.getEmail());
            ps.setString(2, userModel.getUsername());
            ps.setString(3, userModel.getFullname());
            ps.setString(4, userModel.getPassword());
            ps.setString(5, userModel.getImage());
            ps.setInt(6, userModel.getRoleid());
            ps.setString(7, userModel.getPhone());
            ps.setDate(8, userModel.getCreatedate());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkExistUsername(String username) {
        boolean duplicate = false;
        String sql = "SELECT * FROM users WHERE username=?";
        try {
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return duplicate;
    }

    @Override
    public boolean checkExistEmail(String email) {
        boolean duplicate = false;
        String sql = "SELECT * FROM users WHERE email=?";
        try {
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return duplicate;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        boolean duplicate = false;
        String sql = "SELECT * FROM users WHERE phone=?";
        try {
            conn = getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return duplicate;
    }

    public static void main(String[] args) {
        IUserDao userDao = new UserDaoImpl();
        System.out.println(userDao.findByUsername("tuantp2004"));
    }
}
