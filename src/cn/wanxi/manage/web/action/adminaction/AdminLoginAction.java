package cn.wanxi.manage.web.action.adminaction;

import cn.wanxi.manage.web.sercice.AdminService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: takeoutrearestaurant
 * @description: 登录Action
 * @author: Wu Guo
 * @create: 2019-08-30 16:31
 */
public class AdminLoginAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json; charset=UTF-8");//设置输出格式为json，否则为string

        String userName = req.getParameter("userName");
        String password = req.getParameter("userPW");
        JSONObject verdict = new AdminService().verdict(userName, password);

//        HttpSession session=req.getSession();
//        System.out.println(verdict.toString());
//        session.setAttribute("userName",verdict.get(1));
        resp.getWriter().print(verdict);


    }
}
