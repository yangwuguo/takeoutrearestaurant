package cn.wanxi.manage.web.util;

import java.sql.ResultSet;

/**
 * @author WuGuo
 * @description
 * @date 2019-08-28 10:46
 */
public interface RowMap<T> {

        //自定义result结果集
        //使用了匿名内部类的思想
        T rowMapping(ResultSet rs);

}
