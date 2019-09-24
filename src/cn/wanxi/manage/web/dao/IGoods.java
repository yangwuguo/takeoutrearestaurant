package cn.wanxi.manage.web.dao;

import cn.wanxi.manage.web.model.Goods;
import cn.wanxi.manage.web.model.vo.GoodsVo;

import java.util.List;

public interface IGoods {

    List<GoodsVo> getGoodsAll();

    List<Goods> getDishImageByID(int DishID);

    List<Goods> getGoodsByName(String goodsName);

    int delGoodsByID(int DishID);

    int updateGoodsByID(Goods goods);

    int insertGoods(Goods goods);


}
