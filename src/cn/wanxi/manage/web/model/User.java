package cn.wanxi.manage.web.model;

/**
 * 对应User表的实体类
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-18 10:43
 */
public class User {
    private int userID;
    private String userName;
    private String userPW;
    private Integer userType;
    private String userRealName;
    private String userAddRess;
    private String userSex;
    private String userTel;
    private String userEmail;
    private String userQQ;
    private String userAge;
    private String userBirthday;
    private String userXueLi;
    private int userDel;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPW() {
        return userPW;
    }

    public void setUserPW(String userPW) {
        this.userPW = userPW;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserAddRess() {
        return userAddRess;
    }

    public void setUserAddRess(String userAddRess) {
        this.userAddRess = userAddRess;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserQQ() {
        return userQQ;
    }

    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserXueLi() {
        return userXueLi;
    }

    public void setUserXueLi(String userXueLi) {
        this.userXueLi = userXueLi;
    }

    public int getUserDel() {
        return userDel;
    }

    public void setUserDel(int userDel) {
        this.userDel = userDel;
    }
}
