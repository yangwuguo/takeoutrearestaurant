package cn.wanxi.manage.web.action.goodsAction;

import cn.wanxi.manage.web.model.vo.GoodsVo;
import cn.wanxi.manage.web.sercice.GoodsService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-19 17:03
 */
public class GoodsUpdateAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json; charset=UTF-8");

        GoodsVo goodsVo = new GoodsVo();

        JSONObject jsonObject = new GoodsService().insertGoods(goodsVo);
        resp.getWriter().print(jsonObject);
    }
}
