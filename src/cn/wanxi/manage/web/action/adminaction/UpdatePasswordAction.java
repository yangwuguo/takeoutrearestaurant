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
 * @description: 修改密码
 * @author: Wu Guo
 * @create: 2019-09-05 10:24
 */
public class UpdatePasswordAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json; charset=UTF-8");//设置输出格式为json，否则为string

        String name = req.getParameter("name");
        String newPW = req.getParameter("newPW");
        String oldPW = req.getParameter("oldPW");
        Admin admin = new Admin();
        admin.setUserName(name);
        admin.setPassword(newPW);
        //获取判断结果
        JSONObject jsonObject = new AdminService().updatePWResult(admin, oldPW);
        resp.getWriter().print(jsonObject);


    }
}
