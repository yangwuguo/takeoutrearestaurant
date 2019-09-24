package cn.wanxi.manage.web.model;

/**
 * 订单实体类
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-19 10:26
 */
public class Order {
    private int orderID;//订单ID
    private String orderNumber;//订单编号
    private String orderDate;//下单时间
    private String orderActivity;//订单状态
    private float orderAmount;//金额
    private String orderDelivery;//送货地址
    private String orderPayment;//付款方式
    private int orderUserID;//下单用户
    private int orderDel;//显示控制

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderActivity() {
        return orderActivity;
    }

    public void setOrderActivity(String orderActivity) {
        this.orderActivity = orderActivity;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderDelivery() {
        return orderDelivery;
    }

    public void setOrderDelivery(String orderDelivery) {
        this.orderDelivery = orderDelivery;
    }

    public String getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(String orderPayment) {
        this.orderPayment = orderPayment;
    }

    public int getOrderUserID() {
        return orderUserID;
    }

    public void setOrderUserID(int orderUserID) {
        this.orderUserID = orderUserID;
    }

    public int getOrderDel() {
        return orderDel;
    }

    public void setOrderDel(int orderDel) {
        this.orderDel = orderDel;
    }
}
