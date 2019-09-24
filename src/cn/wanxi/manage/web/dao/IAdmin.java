package cn.wanxi.manage.web.dao;

import cn.wanxi.manage.web.model.Admin;

import java.util.List;

public interface IAdmin {

    Admin getAdminByName(String userName);

    List<Admin> getAdminAll();

    int updateAdmin(Admin admin);

    int deleteByID(int adID);

    int insertAdmin(Admin admin);
}
