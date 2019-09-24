package cn.wanxi.manage.web.action.imgaction;

import cn.wanxi.manage.web.sercice.GoodsService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: takeoutrearestaurant
 * @description: 图片展示
 * @author: Wu Guo
 * @create: 2019-09-12 09:05
 */
public class SrcShowAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json; charset=UTF-8");

        String dishID = req.getParameter("dishID");
        JSONObject imagePath = new GoodsService().getImagePath(dishID);
        resp.getWriter().print(imagePath);
    }
}
