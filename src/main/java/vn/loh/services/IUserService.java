package vn.loh.services;

import vn.loh.models.UserModel;

public interface IUserService {
    UserModel findByUsername(String username);
    UserModel login(String username, String password);
    void insert(UserModel userModel);
    boolean register(String username, String password, String email, String fullname, String image, String phone);
    boolean checkExistUsername(String username);
    boolean checkExistEmail(String email);
    boolean checkExistPhone(String phone);
}
