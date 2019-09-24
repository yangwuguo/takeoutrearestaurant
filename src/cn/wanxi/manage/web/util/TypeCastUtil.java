package cn.wanxi.manage.web.util;

/**
 * @author WuGuo
 * @description 类型转换
 * @date 2019-08-26 10:26
 */
public class TypeCastUtil {

    public String elseToString(Object o){
        String str=null;
        str=String.valueOf(o);
        return str;
    }

    public Integer StringToInt(String str){
        Integer i=null;
        if (str!=null){
            i=Integer.parseInt(str);
        }
        return i;
    }
}
