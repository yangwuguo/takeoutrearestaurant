package cn.wanxi.manage.web.action.navaction;

import cn.wanxi.manage.web.sercice.NavAndInfoService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: takeoutrearestaurant
 * @description: 导航栏
 * @author: Wu Guo
 * @create: 2019-09-03 16:52
 */
public class NavAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json; charset=UTF-8");//设置输出格式为json，否则为string

//        System.out.println(req.getParameter("aa"));
        JSONArray navOneByTwo = new NavAndInfoService().getNavOneByTwo();
        resp.getWriter().print(navOneByTwo);
    }
}
