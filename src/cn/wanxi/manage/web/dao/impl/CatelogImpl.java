package cn.wanxi.manage.web.dao.impl;

import cn.wanxi.manage.web.dao.ICatelog;
import cn.wanxi.manage.web.model.Catelog;
import cn.wanxi.manage.web.util.DBLinkUtil;
import cn.wanxi.manage.web.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: takeoutrearestaurant
 * @description:
 * @author: Wu Guo
 * @create: 2019-09-17 17:38
 */
public class CatelogImpl implements ICatelog {
    @Override
    public List<Catelog> getIDByName(String name) {
        String sql = "SELECT catelog_id as id FROM t_catelog WHERE catelog_name = ?";
        List<Catelog> catelogList = DBLinkUtil.query(sql, new RowMap<Catelog>() {
            @Override
            public Catelog rowMapping(ResultSet rst) {
                Catelog catelog = new Catelog();
                try {
                    catelog.setCateLogID(rst.getInt("id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return catelog;
            }
        }, name);
        return catelogList;
    }


    /**
     * 〈获取所有分类名〉
     *
     * @Param: []
     * @Return: java.util.List<cn.wanxi.manage.web.model.Catelog>
     * @Author: WuGuo
     * @Date: 2019/9/20 10:19
     */
    @Override
    public List<Catelog> getCatelogName() {
        String sql = "SELECT catelog_name as name FROM t_catelog";
        List<Catelog> catelogNameList = DBLinkUtil.query(sql, new RowMap<Catelog>() {
            @Override
            public Catelog rowMapping(ResultSet rst) {
                Catelog catelog = new Catelog();
                try {
                    catelog.setCateLogName(rst.getString("name"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return catelog;
            }
        });
        return catelogNameList;
    }
}
