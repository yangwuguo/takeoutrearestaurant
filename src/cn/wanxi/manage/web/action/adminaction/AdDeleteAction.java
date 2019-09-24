package cn.wanxi.manage.web.action.adminaction;

import cn.wanxi.manage.web.sercice.AdminService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: takeoutrearestaurant
 * @description: 删除管理功能
 * @author: Wu Guo
 * @create: 2019-09-06 15:54
 */
public class AdDeleteAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json; charset=UTF-8");
        String userID = req.getParameter("ID");
        JSONObject jsonObject = new AdminService().deleteAdByID(userID);
        resp.getWriter().print(jsonObject);
    }
}
