package cn.wanxi.manage.web.dao.impl;

import cn.wanxi.manage.web.dao.IUser;
import cn.wanxi.manage.web.model.User;
import cn.wanxi.manage.web.util.DBLinkUtil;
import cn.wanxi.manage.web.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-18 10:55
 */
public class UserImpl implements IUser {

    public List<User> getUserNumber(){
        int num=0;
        String sql="SELECT COUNT(0) FROM `t_user`";
        List<User> userCountList = DBLinkUtil.query(sql, new RowMap<User>() {
            @Override
            public User rowMapping(ResultSet rs) {
                User user=new User();
                try {
                    user.setUserID(rs.getInt(1));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
            }
        });
        return userCountList;
    }

    /**
     * 〈获取User表一定条数的数据
     *  用于前端的数据分页〉
     * @Param: [a, b]
     * @Return: java.util.List<cn.wanxi.manage.web.model.User>
     * @Author: WuGuo
     * @Date: 2019/9/18 10:59
     */
    @Override
    public List<User> getUserToShow(int a,int b) {
        String sql="SELECT * FROM `t_user` ORDER BY 'user_id' LIMIT ?,?";
        List<User> userCountList = DBLinkUtil.query(sql, new RowMap<User>() {
            @Override
            public User rowMapping(ResultSet rs) {
                User user=new User();
                try {
                    user.setUserID(rs.getInt(1));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
            }
        });
        return null;
    }

    /**
     * 〈获取User表所有数据〉
     * @Param: []
     * @Return: java.util.List<cn.wanxi.manage.web.model.User>
     * @Author: WuGuo
     * @Date: 2019/9/18 10:56
     */
    @Override
    public List<User> getUserAll() {
        return null;
    }

    /**
     * 〈根据userID对数据库进行删除，隐藏ID指向数据〉
     * @Param: [userID]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/18 11:00
     */
    @Override
    public int delUserByID(int userID) {
        return 0;
    }

    @Override
    public int updateUserByID(User user) {
        return 0;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public int[] insertUsers(List<User> userList) {
        return new int[0];
    }

    /**
     * 功能描述: 从ResultSet中获取值
     *
     * @Param: [rst]
     * @Return: cn.wanxi.manage.web.model.Admin
     * @Author: WuGuo
     * @Date: 2019/9/2 14:28
     */
    private User getAdminByRs(ResultSet rst) {
        try {
            if (rst.getInt("user_del") == 1) {
                User user = new User();

                user.setUserID(rst.getInt("id"));
                user.setUserName(rst.getString("username"));
                user.setUserPW(rst.getString("user_pw"));
                user.setUserRealName(rst.getString("ad_del"));
                user.setUserAddRess(rst.getString("id"));
                user.setUserSex(rst.getString("username"));
//                user.setPassword(rst.getString("user_pw"));
//                user.setDel(rst.getInt("ad_del"));
//                user.setDel(rst.getInt("ad_del"));
//                user.setDel(rst.getInt("ad_del"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
