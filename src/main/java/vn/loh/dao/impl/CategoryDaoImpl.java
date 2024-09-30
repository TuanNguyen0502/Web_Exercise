package vn.loh.dao.impl;

import vn.loh.configs.DBConnectMySQL;
import vn.loh.dao.ICategoryDao;
import vn.loh.models.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl extends DBConnectMySQL implements ICategoryDao {
    public Connection connection = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    @Override
    public List<CategoryModel> findAll() {
        List<CategoryModel> categories = new ArrayList<>();
        String sql = "Select * from categories";

        try {
            // get connection
            connection = getDatabaseConnection();
            // prepare statement
            preparedStatement = connection.prepareStatement(sql);
            // execute query
            resultSet = preparedStatement.executeQuery();
            // get data
            while (resultSet.next()) {
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.setId(resultSet.getInt("id"));
                categoryModel.setName(resultSet.getString("name"));
                categoryModel.setImage(resultSet.getString("image"));
                categoryModel.setStatus(resultSet.getInt("status"));
                categories.add(categoryModel);
//                categories.add(new CategoryModel(
//                        resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getString("image"),
//                        resultSet.getInt("status")
//                ));
            }
            // close connection
            connection.close();
            preparedStatement.close();
            resultSet.close();

            return categories;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CategoryModel findByID(int id) {
        String sql = "Select * from categories where id = ?";

        try {
            // get connection
            connection = getDatabaseConnection();
            // prepare statement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            // execute query
            resultSet = preparedStatement.executeQuery();
            // get data
            while (resultSet.next()) {
                CategoryModel category = new CategoryModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("image"),
                        resultSet.getInt("status")
                );
                return category;
            }
            // close connection
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(CategoryModel category) {
        String sql = "Insert into categories(name, image, status) values(?, ?, ?)";

        try {
            // get connection
            connection = getDatabaseConnection();
            // prepare statement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getImage());
            preparedStatement.setInt(3, category.getStatus());
            // execute query
            preparedStatement.executeUpdate();
            // close connection
            connection.close();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CategoryModel category) {
        String sql = "Update categories set name = ?, image = ?, status = ? where id = ?";

        try {
            // get connection
            connection = getDatabaseConnection();
            // prepare statement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getImage());
            preparedStatement.setInt(3, category.getStatus());
            preparedStatement.setInt(4, category.getId());
            // execute query
            preparedStatement.executeUpdate();
            // close connection
            connection.close();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "Delete from categories where id = ?";

        try {
            // get connection
            connection = getDatabaseConnection();
            // prepare statement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            // execute query
            preparedStatement.executeUpdate();
            // close connection
            connection.close();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CategoryModel> findByName(String name) {
        List<CategoryModel> categories = new ArrayList<>();
        String sql = "Select * from categories where name like ?";

        try {
            // get connection
            connection = getDatabaseConnection();
            // prepare statement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            // execute query
            resultSet = preparedStatement.executeQuery();
            // get data
            while (resultSet.next()) {
                categories.add(new CategoryModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("image"),
                        resultSet.getInt("status")
                ));
            }
            // close connection
            connection.close();
            preparedStatement.close();
            resultSet.close();

            return categories;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
