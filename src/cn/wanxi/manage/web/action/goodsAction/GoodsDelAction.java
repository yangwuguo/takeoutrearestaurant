package cn.wanxi.manage.web.action.goodsAction;

import cn.wanxi.manage.web.sercice.GoodsService;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-18 10:26
 */
public class GoodsDelAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json; charset=UTF-8");

        String dishID = req.getParameter("ID");
        if (dishID!=""&&dishID!=null) {
            JSONObject jsonObject = new GoodsService().delGoodsByID(Integer.parseInt(dishID));
            resp.getWriter().print(jsonObject);
        }
    }
}
