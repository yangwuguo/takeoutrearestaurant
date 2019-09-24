package cn.wanxi.manage.web.model;

/**
 * @program: takeoutrearestaurant
 * @description: 菜品类别
 * @author: Wu Guo
 * @create: 2019-09-17 17:34
 */
public class Catelog {
    private Integer cateLogID;
    private String cateLogName;
    private String cateLogDesc;
    private Integer del;

    public Integer getCateLogID() {
        return cateLogID;
    }

    public void setCateLogID(Integer cateLogID) {
        this.cateLogID = cateLogID;
    }

    public String getCateLogName() {
        return cateLogName;
    }

    public void setCateLogName(String cateLogName) {
        this.cateLogName = cateLogName;
    }

    public String getCateLogDesc() {
        return cateLogDesc;
    }

    public void setCateLogDesc(String cateLogDesc) {
        this.cateLogDesc = cateLogDesc;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}
