package cn.wanxi.manage.web.model;

/**
 * @program: takeoutrearestaurant
 * @description: 导航栏
 * @author: Wu Guo
 * @create: 2019-09-03 15:53
 */
public class Nav {
    private Integer navID;
    private String navName;
    private Integer navFatherID;
    private String navPointUrl;

    public Integer getNavID() {
        return navID;
    }

    public void setNavID(Integer navID) {
        this.navID = navID;
    }

    public String getNavName() {
        return navName;
    }

    public void setNavName(String navName) {
        this.navName = navName;
    }

    public Integer getNavFatherID() {
        return navFatherID;
    }

    public void setNavFatherID(Integer navFatherID) {
        this.navFatherID = navFatherID;
    }

    public String getNavPointUrl() {
        return navPointUrl;
    }

    public void setNavPointUrl(String navPointUrl) {
        this.navPointUrl = navPointUrl;
    }
}
