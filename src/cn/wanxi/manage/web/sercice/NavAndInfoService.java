package cn.wanxi.manage.web.sercice;

import cn.wanxi.manage.web.dao.INav;
import cn.wanxi.manage.web.dao.impl.NavImpl;
import cn.wanxi.manage.web.model.Nav;
import cn.wanxi.manage.web.util.getComputerInfoUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: takeoutrearestaurant
 * @description: 导航栏
 * @author: Wu Guo
 * @create: 2019-09-03 16:05
 */
public class NavAndInfoService {
    private INav nav=new NavImpl();
    public JSONArray getNavOneByTwo(){
        List<Nav> allNav = nav.getAllNav();
        List<Nav> list1=new ArrayList<>();
        List<Nav> list2=new ArrayList<>();
        //将表中获取到的混合数据分割成两个list集合
        for (Nav nav:allNav){
            if (nav.getNavID()%1000==0){
                list1.add(nav);
            }else {
                list2.add(nav);
            }
        }
        //通过循环把二级导航和一级导航一一对应
        JSONArray jsonArray=new JSONArray();
        for (Nav nav:list1){
            for (Nav navSon:list2){
                if (nav.getNavID().equals(navSon.getNavFatherID())){
                    JSONObject json=new JSONObject();
                    json.put("navOneID",nav.getNavID());
                    json.put("navOneName",nav.getNavName());
                    json.put("navTwoName",navSon.getNavName());
                    json.put("navTwoUrl",navSon.getNavPointUrl());
                    jsonArray.add(json);
                }
            }
        }
//        System.out.println(jsonArray.toString());
        return jsonArray;
    }

    /**
     * 功能描述: <br>
     * 〈获取计算机信息〉
     * @Param: []
     * @Return: net.sf.json.JSONObject
     * @Author: WuGuo
     * @Date: 2019/9/5 19:21
     */
    public JSONObject getSystemInfo() {
        JSONObject jsonObject = new getComputerInfoUtil().getComputerInfo();
        return jsonObject;
    }
}
