package cn.wanxi.manage.web.sercice;

import cn.wanxi.manage.web.dao.IAdmin;
import cn.wanxi.manage.web.dao.impl.AdminImpl;
import cn.wanxi.manage.web.model.Admin;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import java.util.List;


/**
 * @program: 登录验证
 * @description: 管理员登录
 * @author: Wu Guo
 * @create: 2019-08-30 16:56
 */
public class AdminService {
    private IAdmin iAdmin = new AdminImpl();
    private JSONObject json = new JSONObject();

    /**
     * 功能描述: 判断用户登录
     * 根据用户名获取信息
     *
     * @Param: [userName, password]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/8/30 17:07
     */
    public JSONObject verdict(String userName, String password) {
        Admin admin = iAdmin.getAdminByName(userName);
        if (admin.getUserID() != null) {
            if (admin.getPassword().equals(password)) {
                json.put("verify", 1);
                json.put("reply", "登录成功！");
                json.put("userName", admin.getUserName());
//                json.put("userID",admin.getUserID());
            } else {
                json.put("verify", 0);
                json.put("reply", "登录失败！");
            }
        } else {
            json.put("verify", 0);
            json.put("reply", "登录失败，用户不存在！！！");
        }

        return json;
    }

    /**
     * 功能描述: <br>
     * 〈获取所有用户信息〉
     *
     * @Param: []
     * @Return: java.util.List<cn.wanxi.manage.web.model.Admin>
     * @Author: WuGuo
     * @Date: 2019/9/5 18:39
     */
    public JSONArray adminAll() {
        List<Admin> adminAll = iAdmin.getAdminAll();
        JSONArray jsonArray = JSONArray.fromObject(adminAll);
        //使用循环转换
//        for(Admin admin:adminAll){
//            json.put("ID",admin.getUserID());
//            json.put("name",admin.getUserName());
//            json.put("password",admin.getPassword());
//            jsonArray.add(json);
//        }
//        直接将list装换为JSONArray

//        System.out.println(jsonArray);

        return jsonArray;
    }

    /**
     * 功能描述: <br>
     * 〈修改密码〉
     *
     * @Param: [ad, oldPW]
     * @Return: net.sf.json.JSONObject
     * @Author: WuGuo
     * @Date: 2019/9/6 17:14
     */
    public JSONObject updatePWResult(Admin ad, String oldPW) {
        //判断原密码是否正确
        if (theAdminJudge(ad, oldPW)) {
            int i = iAdmin.updateAdmin(ad);
            if (i > 0) {
                json.put("reply", "修改成功");
            } else {
                json.put("reply", "修改失败");
            }
        } else {
            json.put("reply", "原密码错误，请检查后重新输入！！！");
        }
        return json;
    }

    /**
     * 功能描述: <br>
     * 〈删除用户信息〉
     *
     * @Param: [userID]
     * @Return: net.sf.json.JSONObject
     * @Author: WuGuo
     * @Date: 2019/9/6 19:36
     */
    public JSONObject deleteAdByID(String userID) {
        if (userID != null) {
            int i = iAdmin.deleteByID(Integer.parseInt(userID));
//            System.out.println(i);
            if (i > 0) {
                json.put("reply", "删除成功");
            } else {
                json.put("reply", "删除失败");
            }
        }
        return json;
    }

    public JSONObject insertAdmin(Admin admin) {
        String password = admin.getPassword();
        String userName = admin.getUserName();
        if (password != "" && userName != "" && userName != null && password != null) {
            int i;
            if (adExistsJudge(admin.getUserName())) {
                json.put("reply", "用户名存在！！！");
                json.put("verify",0);
                return json;
            } else {
                i = iAdmin.insertAdmin(admin);
                if (i > 0) {
                    json.put("reply", "添加成功");
                    json.put("verify",1);
                } else {
                    json.put("reply", "添加失败");
                    json.put("verify",0);
                }
            }
        } else {
            json.put("reply", "用户名或密码都不能为空");
        }
        return json;
    }


    /**
     * 功能描述: <br>
     * 〈判断用户原密码是否正确〉
     *
     * @Param: [ad, oldPW]
     * @Return: boolean
     * @Author: WuGuo
     * @Date: 2019/9/6 19:40
     */
    private boolean theAdminJudge(Admin ad, String oldPW) {
        Admin adminByName = iAdmin.getAdminByName(ad.getUserName());
        if (adminByName.getPassword().equals(oldPW)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 功能描述: <br>
     * 〈判断用户是否存在〉
     *
     * @Param: [userName]
     * @Return: boolean
     * @Author: WuGuo
     * @Date: 2019/9/7 16:32
     */
    private boolean adExistsJudge(String userName) {
        Admin adminByName = iAdmin.getAdminByName(userName);
        if (adminByName.getUserID() != null) {
//            System.out.println(adminByName.getUserName());
            return true;
        } else {
            return false;
        }
    }

}
