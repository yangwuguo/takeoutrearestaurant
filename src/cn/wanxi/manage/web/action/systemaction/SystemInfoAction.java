package cn.wanxi.manage.web.action.systemaction;

import cn.wanxi.manage.web.sercice.NavAndInfoService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: takeoutrearestaurant
 * @description: 获取系统计算机信息
 * @author: Wu Guo
 * @create: 2019-09-04 09:37
 */
public class SystemInfoAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json; charset=UTF-8");//设置输出格式为json，否则为string
//        System.out.println(req.getParameter("demand"));
        JSONObject json = new NavAndInfoService().getSystemInfo();

//        System.out.println(json.toString());
        resp.getWriter().print(json);
    }
}
