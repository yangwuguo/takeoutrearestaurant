package cn.wanxi.manage.web.dao.impl;

import cn.wanxi.manage.web.dao.INav;
import cn.wanxi.manage.web.model.Nav;
import cn.wanxi.manage.web.util.DBLinkUtil;
import cn.wanxi.manage.web.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: takeoutrearestaurant
 * @description:
 * @author: Wu Guo
 * @create: 2019-09-03 15:58
 */
public class NavImpl implements INav {
    @Override
    public List<Nav> getAllNav() {
        String sql = "SELECT * FROM t_nav";
        List<Nav> navList = DBLinkUtil.query(sql, new RowMap<Nav>() {
            @Override
            public Nav rowMapping(ResultSet rst) {
                Nav nav = new Nav();
                try {
                    nav.setNavID(rst.getInt("nav_id"));
                    nav.setNavName(rst.getString("nav_name"));
                    nav.setNavFatherID(rst.getInt("nav_father_id"));
                    nav.setNavPointUrl(rst.getString("nav_point_url"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return nav;
            }
        });
        return navList;
    }
}
