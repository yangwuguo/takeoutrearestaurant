package cn.wanxi.manage.web.model;

/**
 * 公告实体类
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-19 10:26
 */
public class Notice {
    private int noticeID;//公告ID
    private String noticeTitle;//公告标题
    private String noticeContent;//公告内容
    private String noticeDate;//公告修改时间
    private String noticeAdmin;//公告发布者
    private int noticeDel;//显示控制

    public int getNoticeID() {
        return noticeID;
    }

    public void setNoticeID(int noticeID) {
        this.noticeID = noticeID;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getNoticeAdmin() {
        return noticeAdmin;
    }

    public void setNoticeAdmin(String noticeAdmin) {
        this.noticeAdmin = noticeAdmin;
    }

    public int getNoticeDel() {
        return noticeDel;
    }

    public void setNoticeDel(int noticeDel) {
        this.noticeDel = noticeDel;
    }
}
