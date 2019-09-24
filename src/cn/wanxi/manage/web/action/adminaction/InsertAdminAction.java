package cn.wanxi.manage.web.action.adminaction;

import cn.wanxi.manage.web.model.Admin;
import cn.wanxi.manage.web.sercice.AdminService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: takeoutrearestaurant
 * @description: 添加管理账号
 * @author: Wu Guo
 * @create: 2019-09-06 19:47
 */
public class InsertAdminAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json; charset=UTF-8");//设置输出格式为json，否则为string

        Admin admin=new Admin();
        admin.setUserName(req.getParameter("name"));
        admin.setPassword(req.getParameter("password"));

        JSONObject jsonObject = new AdminService().insertAdmin(admin);

        resp.getWriter().print(jsonObject);
    }
}
