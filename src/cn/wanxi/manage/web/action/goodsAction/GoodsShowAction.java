package cn.wanxi.manage.web.action.goodsAction;

import cn.wanxi.manage.web.sercice.GoodsService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: takeoutrearestaurant
 * @description: 菜品展示
 * @author: Wu Guo
 * @create: 2019-09-17 16:53
 */
public class GoodsShowAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json; charset=UTF-8");

        JSONArray goodsAll = new GoodsService().getGoodsAll();
        resp.getWriter().print(goodsAll);
    }
}
