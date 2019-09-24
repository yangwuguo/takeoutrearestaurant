package cn.wanxi.manage.web.action.adminaction;

import cn.wanxi.manage.web.sercice.AdminService;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: takeoutrearestaurant
 * @description: 暂时所有用户信息
 * @author: Wu Guo
 * @create: 2019-09-05 18:16
 */
public class AdShowAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json; charset=UTF-8");//设置输出格式为json，否则为string
//        System.out.println(req.getParameter("getAd"));
        JSONArray jsonArray = new AdminService().adminAll();
        resp.getWriter().print(jsonArray);
    }
}
