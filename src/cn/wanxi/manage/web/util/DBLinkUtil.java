package cn.wanxi.manage.web.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * @program: BigBusinessCreate
 * @description: 数据库连接工具类
 * @author: Wu Guo
 * @create: 2019-08-21 13:00
 */
public class DBLinkUtil {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //characterEncoding=utf8——传送数据编码格式
    // rewriteBatchedStatements=true——批量添加
    //serverTimezone=UTC——时间
    //useSSL=false——MySQL的版本更高一些，在连接语句后加上“useSSL=‘true’”

    private static final String DB_URL = "jdbc:mysql://localhost:3306/takeout?autoReconnect=true&useSSL=false&serverTimezone=UTC&useAffectedRows=true&rewriteBatchedStatements=true";
    //    ?useAffectedRows=true使update的返回值使受影响的行数
    //数据库用户名以及密码
    private static final String USER = "root";
    private static final String PASSWORD = "00000";


    /**
     * 建立数据库连接
     *
     * @param
     * @return java.sql.Connection
     * @author Mr.Yang
     * @date 2019/8/28 0028 9:31
     */
    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库链接
     *
     * @param conn, pstmt, rs]
     * @return void
     * @author Mr.Yang
     * @date 2019/8/28 0028 9:30
     */
    private static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        //关闭Connection
        try {

            //关闭ResultSet
            if (rs != null) {
                rs.close();
            }

            //关闭PreparedStatement
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 〈增、删、改、单次〉
     *
     * @Param: [sql, objects]
     * @Return: int
     * @Author: WuGuo
     * @Date: 2019/9/19 11:26
     */
    public static int update(String sql, Object... objects) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        ResultSet rest = null;
        int cunt = 0;
        try {
            pstm = conn.prepareStatement(sql);
//            conn.setAutoCommit(false);
//            padding(pstm, objects);
            for (int i = 0; i < objects.length; i++) {
                pstm.setObject(i + 1, objects[i]);

            }
//            pstm.addBatch();
            cunt = pstm.executeUpdate();

//            cunt = pstm.executeBatch();
//            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstm, rest);
        }
        return cunt;
    }

    /**
     * 查询
     * 定义为泛型，使用泛型接口。
     * 传入sql语句，类型，数据，获取相应操作后的数据
     *
     * @param sql, rowMap, objects]
     * @return java.util.List<T>
     * @author Mr.Yang
     * @date 2019/8/28 0028 11:00
     */
    public static <T> List<T> query(String sql, RowMap<T> rowMap, Object... objects) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        ResultSet rest = null;
        List<T> list = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(sql);
//            padding(pstm, objects);
            if (objects.length > 0) {
                for (int i = 0; i < objects.length; i++) {
                    pstm.setObject(i + 1, objects[i]);
                }
            }

            rest = pstm.executeQuery();
            while (rest.next()) {
                T t = rowMap.rowMapping(rest);
                if (t != null) {
                    list.add(t);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstm, rest);
        }
        return list;
    }

    /**
     * 增、删、改（批量操作）
     * 根据传入的sql语句以及数据进行运行PreparedStatement的executeUpdate()
     *
     * @param sql, objects]
     * @return int
     * @author Mr.Yang
     * @date 2019/8/28 0028 10:15
     */
//    [[],[]]
    public static int[] updateBatch(String sql, Object[]... objects) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        ResultSet rest = null;
        int[] cunt = new int[objects.length];
        try {
            pstm = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
//            padding(pstm, objects);

            for (int i = 0; i < objects.length; i++) {
                for (int j = 0; j < objects[i].length; j++) {
                    pstm.setObject(j + 1, objects[i][j]);
                }
                pstm.addBatch();
            }

//            pstm.addBatch();

            cunt = pstm.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstm, rest);
        }
        return cunt;
    }

//    private static void padding(PreparedStatement pstm, Object... objects) throws SQLException {
//        if (objects.length > 0) {
//            for (int i = 0; i < objects.length; i++) {
//                pstm.setObject(i + 1, objects[i]);
//            }
//        }
//    }
}
