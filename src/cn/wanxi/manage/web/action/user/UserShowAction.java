package cn.wanxi.manage.web.action.user;



import cn.wanxi.manage.web.sercice.UserService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-24 15:27
 */
public class UserShowAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json; charset=UTF-8");

        JSONArray usersAll = new UserService().getUsersAll();
        resp.getWriter().print(usersAll);
    }
}
