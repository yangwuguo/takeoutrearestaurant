package cn.wanxi.manage.web.sercice;

import cn.wanxi.manage.web.dao.ICatelog;
import cn.wanxi.manage.web.dao.IGoods;
import cn.wanxi.manage.web.dao.impl.CatelogImpl;
import cn.wanxi.manage.web.dao.impl.GoodsImpl;
import cn.wanxi.manage.web.model.Catelog;
import cn.wanxi.manage.web.model.Goods;
import cn.wanxi.manage.web.model.vo.GoodsVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @program: takeoutrearestaurant
 * @description: 菜品
 * @author: Wu Guo
 * @create: 2019-09-12 11:13
 */
public class GoodsService {
    private IGoods goods = new GoodsImpl();
    private ICatelog catelog = new CatelogImpl();
    private JSONObject json = new JSONObject();

    /**
     * 〈获取所有菜品信息〉
     *
     * @Param: []
     * @Return: net.sf.json.JSONArray
     * @Author: WuGuo
     * @Date: 2019/9/17 16:54
     */
    public JSONArray getGoodsAll() {
        List<GoodsVo> goodsAll = goods.getGoodsAll();
        JSONArray jsonArray = JSONArray.fromObject(goodsAll);

        return jsonArray;
    }

    /**
     * 〈修改菜名图片展示
     * 获取前端ID转换为Integer型
     * 获取数据库数据后台转换为json〉
     *
     * @Param: [dishID]
     * @Return: net.sf.json.JSONObject
     * @Author: WuGuo
     * @Date: 2019/9/17 11:09
     */
    public JSONObject getImagePath(String dishID) {
        Integer id = null;
        if (dishID != null && dishID != "") {
            id = Integer.parseInt(dishID);
        }
        List<Goods> dishImageList = new GoodsImpl().getDishImageByID(id);
        String dishImage = null;
        for (Goods goods : dishImageList) {
            dishImage = goods.getGoodsPic();
        }
        if (dishImage != null && dishImage != "") {
            String imgPath = "..\\images\\dish\\" + dishImage;
            json.put("imgPath", imgPath);
        } else {
            json.put("imgPath", "图片为空！！！");
        }
        return json;
    }

    /**
     * 〈删除，将ID所在行DEl元素进行修改达到隐藏效果〉
     *
     * @Param: [dishID]
     * @Return: net.sf.json.JSONObject
     * @Author: WuGuo
     * @Date: 2019/9/18 10:36
     */
    public JSONObject delGoodsByID(int dishID) {
        json.put("reply", "删除失败");
        int i = new GoodsImpl().delGoodsByID(dishID);
        if (i > 0) {
            json.put("reply", "删除成功");
        }
        return json;
    }

    /**
     * 〈添加菜品信息〉
     *
     * @Param: [dish]
     * @Return: net.sf.json.JSONObject
     * @Author: WuGuo
     * @Date: 2019/9/18 14:40
     */
    public JSONObject insertGoods(GoodsVo goodsVo) {
        json.put("reply", "添加失败");
        List<Goods> goodsByName = goods.getGoodsByName(goodsVo.getGoodsName());//获取前端传回菜名并以此查询
        if (goodsByName!=null&&goodsByName.size()>0) {
            json.put("reply", "添加失败，菜名已存在");
            return json;
        } else {
            Goods dish = goodsToVo(goodsVo);
            int i = goods.insertGoods(dish);
            if (i == 1) {
                json.put("reply", "添加成功");
                return json;
            }
        }
        return json;
    }

    /**
     * 〈将GoodsVo转化为Goods〉
     * @Param: [goodsVo]
     * @Return: cn.wanxi.manage.web.model.Goods
     * @Author: WuGuo
     * @Date: 2019/9/18 16:34
     */
    private Goods goodsToVo(GoodsVo goodsVo) {
        Goods dish = new Goods();
        String goodsCatelog = goodsVo.getGoodsCatelog();
        if (goodsCatelog != null && goodsCatelog != "") {
            List<Catelog> idByName = catelog.getIDByName(goodsCatelog);//查询类别名对应的ID
            Integer cateligID = idByName.get(0).getCateLogID();
            dish.setGoodsCatelogID(cateligID);
            dish.setGoodsName(goodsVo.getGoodsName());
            dish.setGoodsMiaoshu(goodsVo.getGoodsMiaoshu());
            dish.setGoodsPic(goodsVo.getGoodsPic());
            dish.setGoodsShichangjia(Float.parseFloat(goodsVo.getGoodsShichangjia()));
            dish.setGoodsRenqun(goodsVo.getGoodsRenqun());
            dish.setGoodsTejia(Float.parseFloat(goodsVo.getGoodsTejia()));
            dish.setGoodsIsNotTejia(goodsVo.getGoodsIsNotTejia());
            dish.setGoodsIsNotTuijian(goodsVo.getGoodsIsNotTuijian());
        }
        return dish;
    }

}
