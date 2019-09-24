package cn.wanxi.manage.web.model;

/**
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-19 10:34
 */
public class LeaveWord {
    private int LeaveID;//留言ID
    private String LeaveTitle;//留言标题
    private String LeaveContent;//留言内容
    private String LeaveDate;//留言最后修改时间
    private String LeaveUser;//留言用户名
    private int LeaveDel;//显示控制字段

    public int getLeaveID() {
        return LeaveID;
    }

    public void setLeaveID(int leaveID) {
        LeaveID = leaveID;
    }

    public String getLeaveTitle() {
        return LeaveTitle;
    }

    public void setLeaveTitle(String leaveTitle) {
        LeaveTitle = leaveTitle;
    }

    public String getLeaveContent() {
        return LeaveContent;
    }

    public void setLeaveContent(String leaveContent) {
        LeaveContent = leaveContent;
    }

    public String getLeaveDate() {
        return LeaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        LeaveDate = leaveDate;
    }

    public String getLeaveUser() {
        return LeaveUser;
    }

    public void setLeaveUser(String leaveUser) {
        LeaveUser = leaveUser;
    }

    public int getLeaveDel() {
        return LeaveDel;
    }

    public void setLeaveDel(int leaveDel) {
        LeaveDel = leaveDel;
    }
}
