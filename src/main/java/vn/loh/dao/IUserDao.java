package vn.loh.dao;

import vn.loh.models.UserModel;

import java.util.List;

public interface IUserDao {
    List<UserModel> findAll();
    UserModel findById(int id);
    UserModel findByUsername(String username);
    void insert(UserModel userModel);
    boolean checkExistUsername(String username);
    boolean checkExistEmail(String email);
    boolean checkExistPhone(String phone);
}
