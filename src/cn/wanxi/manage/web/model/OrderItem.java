package cn.wanxi.manage.web.model;

/**
 * 订单项目
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-19 10:28
 */
public class OrderItem {
    private int orderItemID;//订单项目编号
    private int orderID;//订单ID
    private int goodsID;//菜单ID
    private int goodsQuantity;//数量

    public int getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(int goodsID) {
        this.goodsID = goodsID;
    }

    public int getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(int goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }
}
