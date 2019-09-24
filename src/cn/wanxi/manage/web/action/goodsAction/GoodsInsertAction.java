package cn.wanxi.manage.web.action.goodsAction;

import cn.wanxi.manage.web.dao.impl.GoodsImpl;
import cn.wanxi.manage.web.model.Goods;
import cn.wanxi.manage.web.model.vo.GoodsVo;
import cn.wanxi.manage.web.sercice.GoodsService;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 添加菜品
 *
 * @program: takeoutrearestaurant
 * @author: Wu Guo
 * @create: 2019-09-18 14:21
 */
public class GoodsInsertAction extends HttpServlet {
    private String filePath;
    GoodsVo goodsVos = new GoodsVo();

    public void init() {
        // 获取文件将被存储的位置
        filePath =
                getServletContext().getInitParameter("dish-img-src");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//
//        GoodsVo goodsVo = new GoodsVo();
//
//        goodsVo.setGoodsName("sss");
//
//        goodsVo.setGoodsMiaoshu(req.getParameter("goodName"));
//        goodsVo.setGoodsPic(req.getParameter("goodName"));
//
//        if (req.getParameter("goodName") != null) {
//            goodsVo.setGoodsCatelog(req.getParameter("goodName"));
//        }
//        if (req.getParameter("goodName")!=null)
//        goods.setGoodsShichangjia();
//        goodsVo.setGoodsRenqun(req.getParameter("goodName"));
//
//        JSONObject jsonObject = new GoodsService().insertGoods(goodsVo);
//        System.out.println(jsonObject.toString());
//        resp.getWriter().print(jsonObject);
        //1.创建文件上传工厂类
        DiskFileItemFactory fac = new DiskFileItemFactory();
        //2.创建文件上传核心类对象
        ServletFileUpload upload = new ServletFileUpload(fac);

        req.setCharacterEncoding("utf-8");
        //【一、设置单个文件最大30M】
        upload.setFileSizeMax(30 * 1024 * 1024);//30M
        //【二、设置总文件大小：50M】
        upload.setSizeMax(50 * 1024 * 1024); //50M

        GoodsVo goodsVo = new GoodsVo();
        File file = null;
        FileItem items = null;
        //判断，当前表单是否为文件上传表单
        if (upload.isMultipartContent(req)) {
            try {
                //3.把请求数据转换为FileItem对象的集合
                List<FileItem> list = upload.parseRequest(req);
                //遍历，得到每一个上传项
                for (FileItem item : list) {
                    String goodsContent = null;
                    String imgName = item.getName(); //上传的文件名称
                    //判断：是普通表单项，还是文件上传表单项
                    if (item.isFormField()) {
                        //普通表单x
                        goodsContent = item.getString("UTF-8"); //获取元素值
                    } else {
                        //文件上传表单
                        //a.随机生成一个唯一标记
                        String id = UUID.randomUUID().toString();
                        //与文件名拼接
                        imgName = id + imgName;
                        //创建文件对象
                        file = new File(filePath, imgName);
                        items = item;
                    }
                    //将信息装进GoodsVo
                    goodsVo = gotoGoodsVo(goodsContent, imgName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("不处理！");
        }
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json; charset=UTF-8");
        JSONObject jsonObject = new GoodsService().insertGoods(goodsVo);
        if (jsonObject.getString("reply") == "添加成功") {
            try {
                items.write(file);
                items.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        resp.getWriter().print(jsonObject);
    }

    private GoodsVo gotoGoodsVo(String goodsContent, String imgName) {

        if (goodsContent != null && goodsContent != "") {
            JSONObject json = JSONObject.fromObject(goodsContent);
            goodsVos.setGoodsName(json.getString("Name"));
            if (json.getString("MiaoShu") != "" && json.getString("MiaoShu") != null) {
                goodsVos.setGoodsMiaoshu(json.getString("MiaoShu"));
            } else {
                goodsVos.setGoodsMiaoshu("无");
            }
            goodsVos.setGoodsCatelog(json.getString("CateLog"));
            goodsVos.setGoodsShichangjia(json.getString("ShiChangJia"));
            goodsVos.setGoodsIsNotTejia(json.getString("IsNotTeJia"));
            goodsVos.setGoodsIsNotTuijian(json.getString("TuiJan"));
            goodsVos.setGoodsRenqun(json.getString("RenQun"));
            if (json.getString("IsNotTeJia").equals("是")) {
                goodsVos.setGoodsTejia(json.getString("TeJia"));
            }else {
                goodsVos.setGoodsTejia("0");
            }
        }
        if (imgName != null && imgName != "") {
            goodsVos.setGoodsPic(imgName);
        }

        return goodsVos;
    }
}
