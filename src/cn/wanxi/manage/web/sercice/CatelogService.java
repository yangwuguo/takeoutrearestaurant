package cn.wanxi.manage.web.sercice;

import cn.wanxi.manage.web.dao.ICatelog;
import cn.wanxi.manage.web.dao.impl.CatelogImpl;
import cn.wanxi.manage.web.model.Catelog;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-20 10:23
 */
public class CatelogService {
    private ICatelog catelog = new CatelogImpl();
    private JSONObject json = new JSONObject();


    public JSONArray getCatelogName(){
        JSONArray jsonArray=new JSONArray();
        List<Catelog> catelogList = catelog.getCatelogName();
        for (Catelog c:catelogList){
            json.put("catelogName",c.getCateLogName());
            jsonArray.add(json);
        }
        return jsonArray;
    }

}
