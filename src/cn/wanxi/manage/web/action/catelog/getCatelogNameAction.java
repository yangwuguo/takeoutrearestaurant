package cn.wanxi.manage.web.action.catelog;

import cn.wanxi.manage.web.sercice.CatelogService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取所有菜品分类名
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-20 10:16
 */
public class getCatelogNameAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json; charset=UTF-8");

        JSONArray jsonArray = new CatelogService().getCatelogName();
        resp.getWriter().print(jsonArray);
    }
}
