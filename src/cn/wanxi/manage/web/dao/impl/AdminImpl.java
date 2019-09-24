package cn.wanxi.manage.web.dao.impl;

import cn.wanxi.manage.web.dao.IAdmin;
import cn.wanxi.manage.web.model.Admin;
import cn.wanxi.manage.web.util.DBLinkUtil;
import cn.wanxi.manage.web.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: takeoutrearestaurant
 * @description:
 * @author: Wu Guo
 * @create: 2019-08-30 15:53
 */
public class AdminImpl implements IAdmin {

    /**
     * 功能描述: <br>
     * 〈根据用户名获取用户信息〉
     *
     * @Param: [userName]
     * @Return: cn.wanxi.manage.web.model.Admin
     * @Author: WuGuo
     * @Date: 2019/9/5 18:09
     */
    @Override
    public Admin getAdminByName(String userName) {
        String sql = "SELECT * FROM t_admin WHERE username = ? ";
        List<Admin> adminList = DBLinkUtil.query(sql, new RowMap<Admin>() {
            @Override
            public Admin rowMapping(ResultSet rst) {
                Admin admin = getAdminByRs(rst);

                return admin;
            }
        }, userName);
        Admin admin = new Admin();
        for (Admin a : adminList) {
            admin = a;
        }
        return admin;
    }

    /**
     * 功能描述: <br>
     * 〈查询用户表中所有用户信息〉
     *
     * @Param: []
     * @Return: java.util.List<cn.wanxi.manage.web.model.Admin>
     * @Author: WuGuo
     * @Date: 2019/9/5 18:10
     */
    @Override
    public List<Admin> getAdminAll() {
        String sql = "SELECT * FROM t_admin";
        List<Admin> adminList = DBLinkUtil.query(sql, new RowMap<Admin>() {
            @Override
            public Admin rowMapping(ResultSet rs) {
                Admin admin = getAdminByRs(rs);
                return admin;
            }
        });

        return adminList;
    }

    /**
     * 功能描述: <br>
     * 〈根据用户名进行密码修改〉
     *
     * @return
     * @Param: [admin]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/5 18:09
     */
    @Override
    public int updateAdmin(Admin admin) {
        String sql = "UPDATE t_admin SET user_pw = ? WHERE username = ?";
        Object[] objects = new Object[]{admin.getPassword(), admin.getUserName()};
        int receipt = DBLinkUtil.update(sql, objects);

        return receipt;
    }


    /**
     * 功能描述: <br>
     * 〈根据前端传来的ID删除用户--将用户信息隐藏〉
     *
     * @return
     * @Param: [adID]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/6 17:08
     */
    @Override
    public int deleteByID(int adID) {
//        String sql = "DELETE FROM t_admin WHERE id = ?";
        String sql = "UPDATE t_admin SET ad_del = ? WHERE id = ?";
        Object[] objects = new Object[]{0, adID};
        int receipt = DBLinkUtil.update(sql, objects);
        return receipt;
    }

    /**
     * 功能描述: <br>
     * 〈新增管理员信息〉
     *
     * @return
     * @Param: [admin]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/6 19:33
     */
    @Override
    public int insertAdmin(Admin admin) {
        String sql = "INSERT INTO t_admin (username, user_pw) VALUES (?, ?)";
        Object[] objects = new Object[]{admin.getUserName(), admin.getPassword()};
        int receipt = DBLinkUtil.update(sql, objects);
        return receipt;
    }


    /**
     * 功能描述: 从ResultSet中获取值
     *
     * @Param: [rst]
     * @Return: cn.wanxi.manage.web.model.Admin
     * @Author: WuGuo
     * @Date: 2019/9/2 14:28
     */
    private Admin getAdminByRs(ResultSet rst) {
        try {
            if (rst.getInt("ad_del") == 1) {
                Admin admin = new Admin();

                admin.setUserID(rst.getInt("id"));
                admin.setUserName(rst.getString("username"));
                admin.setPassword(rst.getString("user_pw"));
                admin.setDel(rst.getInt("ad_del"));
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}