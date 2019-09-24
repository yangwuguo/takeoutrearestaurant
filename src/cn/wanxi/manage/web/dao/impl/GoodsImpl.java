package cn.wanxi.manage.web.dao.impl;

import cn.wanxi.manage.web.dao.IGoods;
import cn.wanxi.manage.web.model.Goods;
import cn.wanxi.manage.web.model.vo.GoodsVo;
import cn.wanxi.manage.web.util.DBLinkUtil;
import cn.wanxi.manage.web.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: takeoutrearestaurant
 * @description:
 * @author: Wu Guo
 * @create: 2019-09-12 10:28
 */
public class GoodsImpl implements IGoods {

    /**
     * 〈获取所有的菜单信息〉
     *
     * @Param: [goods]
     * @Return: int[]
     * @Author: WuGuo
     * @Date: 2019/9/17 10:58
     */
    @Override
    public List<GoodsVo> getGoodsAll() {
        String sql = "SELECT goods_id,goods_name,goods_miaoshu,goods_pic,goods_shichangjia,goods_tejia,goods_renqun,goods_del,catelog_name " +
                "FROM t_goods A " +
                "inner join t_catelog B " +
                "on A.goods_catelog_id=B.catelog_id ";
        List<GoodsVo> adminList = DBLinkUtil.query(sql, new RowMap<GoodsVo>() {
            @Override
            public GoodsVo rowMapping(ResultSet rs) {
                GoodsVo goodsVo = new GoodsVo();
                try {
                    if (rs.getInt("goods_del") == 1) {
                        goodsVo.setGoodsID(rs.getInt("goods_id"));
                        goodsVo.setGoodsName(rs.getString("goods_name"));
                        goodsVo.setGoodsMiaoshu(rs.getString("goods_miaoshu"));
                        goodsVo.setGoodsCatelog(rs.getString("catelog_name"));
                        goodsVo.setGoodsPic(rs.getString("goods_pic"));
                        goodsVo.setGoodsShichangjia(rs.getString("goods_shichangjia"));
                        goodsVo.setGoodsTejia(rs.getString("goods_tejia"));
                        goodsVo.setGoodsRenqun(rs.getString("goods_renqun"));
                        goodsVo.setGoodsDel(rs.getInt("goods_del"));
                        return goodsVo;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
        return adminList;
    }


    /**
     * 〈获取指定ID信息的图片路径〉
     *
     * @Param: [DishID]
     * @Return: java.util.List<cn.wanxi.manage.web.model.Goods>
     * @Author: WuGuo
     * @Date: 2019/9/17 10:59
     */
    @Override
    public List<Goods> getDishImageByID(int DishID) {
        String sql = "SELECT goods_pic FROM t_goods WHERE goods_id = ?";
        List<Goods> goods_pic = DBLinkUtil.query(sql, new RowMap<Goods>() {
            @Override
            public Goods rowMapping(ResultSet rst) {
                Goods goods = new Goods();
                try {
                    goods.setGoodsPic(rst.getString("goods_pic"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return goods;
            }
        }, DishID);
        return goods_pic;
    }

    /**
     * 〈根据菜名查询有数据〉
     *
     * @Param: [goodsName]
     * @Return: java.util.List<cn.wanxi.manage.web.model.Goods>
     * @Author: WuGuo
     * @Date: 2019/9/18 12:40
     */
    @Override
    public List<Goods> getGoodsByName(String goodsName) {
        String sql = "SELECT * FROM t_goods WHERE goods_name = ?";
        List<Goods> goodsList = DBLinkUtil.query(sql, new RowMap<Goods>() {
                    @Override
                    public Goods rowMapping(ResultSet rst) {
                        Goods goods = new Goods();
                        try {
                            goods.setGoodsID(rst.getInt("goods_id"));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return goods;
                    }
                },goodsName);

        return goodsList;
    }


    /**
     * 〈利用修改特特定的字段使其不显示
     * 模拟删除功能〉
     *
     * @Param: [DishID]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/18 9:37
     */
    @Override
    public int delGoodsByID(int DishID) {
        String sql = "UPDATE t_goods SET goods_del = ? WHERE goods_id = ?";
        Object[] objects = new Object[]{0, DishID};
        int receipt = DBLinkUtil.update(sql, objects);

        return receipt;
    }


    /**
     * 〈根据传回的数据修改数据库信息〉
     *
     * @Param: [goods]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/18 9:39
     */
    @Override
    public int updateGoodsByID(Goods goods) {
        String sql="UPDATE t-goods SET goods_name=?,goods_miaoshu=?,goods_catelog_id=?" +
                "goods_pic=?,goods_shichangjia=?,goods_tejia=?,goods_isnottejia=?,goods_isnottuijian=?," +
                "goods_renqun=? WHERE goods_id = ?";

//        Object goodsObject = toGoodsObject(goods);
        Object[] objects=new Object[]{goods.getGoodsName(),
                goods.getGoodsMiaoshu(),
                goods.getGoodsCatelogID(),
                goods.getGoodsPic(),
                goods.getGoodsShichangjia(),
                goods.getGoodsTejia(),
                goods.getGoodsIsNotTejia(),
                goods.getGoodsIsNotTejia(),
                goods.getGoodsRenqun()
        } ;

        int receipt = DBLinkUtil.update(sql, goods.getGoodsName(),
                goods.getGoodsMiaoshu(),
                goods.getGoodsCatelogID(),
                goods.getGoodsPic(),
                goods.getGoodsShichangjia(),
                goods.getGoodsTejia(),
                goods.getGoodsIsNotTejia(),
                goods.getGoodsIsNotTejia(),
                goods.getGoodsRenqun());

        return receipt;
    }


    /**
     * 〈新增菜品信息〉
     *
     * @Param: [dishPath]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/17 15:33
     */
    @Override
    public int insertGoods(Goods goods) {
        String sql = "INSERT INTO t_goods " +
                "(goods_name, goods_miaoshu,goods_catelog_id,goods_pic,goods_shichangjia," +
                "goods_tejia,goods_isnottejia,goods_isnottuijian,goods_renqun)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] objects=new Object[]{
        } ;
        int receipt = DBLinkUtil.update(sql,goods.getGoodsName(),
                goods.getGoodsMiaoshu(),
                goods.getGoodsCatelogID(),
                goods.getGoodsPic(),
                goods.getGoodsShichangjia(),
                goods.getGoodsTejia(),
                goods.getGoodsIsNotTejia(),
                goods.getGoodsIsNotTejia(),
                goods.getGoodsRenqun());
        return receipt;
    }

}
