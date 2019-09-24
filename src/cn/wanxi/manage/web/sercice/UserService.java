package cn.wanxi.manage.web.sercice;

import cn.wanxi.manage.web.dao.IUser;
import cn.wanxi.manage.web.dao.impl.UserImpl;
import cn.wanxi.manage.web.model.User;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-24 15:43
 */
public class UserService {
    private IUser user=new UserImpl();

    public JSONArray getUsersAll(int begin,int end) {
        List<User> userList = user.getUserToShow(begin,end);
        JSONArray jsonArray = JSONArray.fromObject(userList);

        return jsonArray;
    }
}
