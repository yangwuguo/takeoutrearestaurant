package cn.wanxi.manage.web.action.imgaction;


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
 * @program: takeoutrearestaurant
 * @description: 上传图片
 * @author: Wu Guo
 * @create: 2019-09-11 09:18
 */
public class UploadAction extends HttpServlet {

    private String filePath;

    public void init() {
        // 获取文件将被存储的位置
        filePath =
                getServletContext().getInitParameter("dish-img-src");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        //1.创建文件上传工厂类
        DiskFileItemFactory fac = new DiskFileItemFactory();
        //2.创建文件上传核心类对象
        ServletFileUpload upload = new ServletFileUpload(fac);

        req.setCharacterEncoding("utf-8");
        //【一、设置单个文件最大30M】
        upload.setFileSizeMax(30 * 1024 * 1024);//30M
        //【二、设置总文件大小：50M】
        upload.setSizeMax(50 * 1024 * 1024); //50M

        //判断，当前表单是否为文件上传表单
        if (upload.isMultipartContent(req)) {

            try {
                //3.把请求数据转换为FileItem对象的集合
                List<FileItem> list = upload.parseRequest(req);

                //遍历，得到每一个上传项
                for (FileItem item : list) {
                    //判断：是普通表单项，还是文件上传表单项
                    String goodName = null;
                    if (item.isFormField()) {
                        //普通表单x
                        String fieldName = item.getFieldName();//获取元素名称
                        goodName = item.getString("UTF-8"); //获取元素值
                        System.out.println(fieldName + " : " + goodName);

                    } else {
                        //文件上传表单

                        String name = item.getName(); //上传的文件名称
                        /**
                         * 【四、文件重名】
                         * 对于不同的用户的test.txt文件，不希望覆盖，
                         * 后台处理：给用户添加一个唯一标记！
                         */
                        //a.随机生成一个唯一标记
                        String id = UUID.randomUUID().toString();
                        //与文件名拼接
                        if (goodName!=null&&goodName!=""){

                        }else {
                            name = id + name;
                        }

                        //【三、上传到指定目录：获取上传目录路径】
//                        String realPath = getServletContext().getRealPath("/uploadImg");
                        //创建文件对象
                        File file = new File(filePath, name);
                        System.out.println(file.toString());
                        item.write(file);
                        item.delete();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("不处理！");
        }

    }
}
