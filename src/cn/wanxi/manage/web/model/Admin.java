package cn.wanxi.manage.web.model;

/**
 * @program: takeoutrearestaurant
 * @description: admin实体类
 * @author: Wu Guo
 * @create: 2019-08-30 15:30
 */
public class Admin {
    /**
     * 管理员ID
     */
    private Integer userID;
    /**
     * 管理员登录用户名
     */
    private String userName;
    /**
     * 管理员的登录密码
     */
    private String password;

    //删除键
    private Integer del;


    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }



    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
