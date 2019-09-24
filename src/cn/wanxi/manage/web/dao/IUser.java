package cn.wanxi.manage.web.dao;

import cn.wanxi.manage.web.model.User;

import java.util.List;

public interface IUser {

    List<User> getUserToShow(int a,int b);

    List<User> getUserAll();

    int delUserByID(int userID);

    int updateUserByID(User user);

    int insertUser(User user);

    int[] insertUsers(List<User> userList);
}
