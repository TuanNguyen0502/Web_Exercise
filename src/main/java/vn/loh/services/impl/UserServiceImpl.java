package vn.loh.services.impl;

import vn.loh.dao.IUserDao;
import vn.loh.dao.impl.UserDaoImpl;
import vn.loh.models.UserModel;
import vn.loh.services.IUserService;

public class UserServiceImpl implements IUserService {
    IUserDao userDao = new UserDaoImpl();

    @Override
    public UserModel findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public UserModel login(String username, String password) {
        UserModel user = this.findByUsername(username);

        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public void insert(UserModel userModel) {
        userDao.insert(userModel);
    }

    @Override
    public boolean register(String username, String password, String email, String fullname, String image, String phone) {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        userDao.insert(new UserModel(username, password, email, fullname, image, 3, date, phone));
        return true;
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    public static void main(String[] args) {
        try {
            IUserService userService = new UserServiceImpl();
            System.out.println(userService.login("tuantp2004", "123456"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
