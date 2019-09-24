package cn.wanxi.manage.web.action.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @program: takeoutrearestaurant
 * @description: 文件下载
 * @author: Wu Guo
 * @create: 2019-09-11 17:22
 */
public class DownloadAction extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        /**重写了Servlet的init(ServletConfig config)方法后一定要记得调用父类的init方法，
         * 否则在service/doGet/doPost方法中使用getServletContext()方法获取ServletContext对象时
         * 就会出现java.lang.NullPointerException异常
         * */
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**1. 接受前端页面发送过来的文件名字
         * 获取到前端页面发送过来的要下载的文件的名字
         * */
        String filenameValue = req.getParameter("filename");
        //---------------------
//      filenameValue = URLEncoder.encode(filenameValue, "gbk");
        /**2. 获取到ServletContext域对象
         * 后面将调用此对象的一系列方法，用于获取文件路径、文件MimeType、文件输出类型
         * */
        ServletContext servletContext = req.getServletContext();  //获取到ServletContext域对象
        /**3. 获取指定文件在web项目中的路径
         * 通过获取到ServletContext域对象的getRealPath()方法，读取download目录下文件的绝对路径
         * download目录必须放在webContent目录下面，否则可能会找不到，导致报异常，
         * 在读取资源的时候，项目demo会直接去查找webContent下面的文件和文件夹
         * */
        String realPath = servletContext.getRealPath("uploadImg/" + filenameValue);  //获取到要下载文件在web项目中的绝对路径
        /**4. 获取到文件MimeType
         * 通过获取到的ServletContext域对象的getMimeType()方法，获取到文件MimeType
         * MIME (Multipurpose Internet Mail Extensions) 是描述消息内容类型的因特网标准。
         * MIME 协议指示 MIME 用户代理如何显示附加的文件。
         * MIME 参考手册：http://www.w3school.com.cn/media/media_mimeref.asp
         * */
        String mimeType = servletContext.getMimeType(filenameValue);  //获取到要下载文件的mimeType类型
        /**5. 设置文件的输出类型
         * Response域对象的setContentType()方法，设置文件的输出类型
         * */
        resp.setContentType(mimeType);  //设置文件的输出类型
        /**6. 设置响应头，确定文件是内嵌或弹出下载框
         * 通过 Response 域对象的 setHeader("Content-Disposition","attachment;filename="+filename) 方法设置响应头，
         * Content-Disposition(内容处置/处理) :
         *      是 MIME 协议的扩展，Content-Disposition 可以控制用户请求所得的内容存为一个文件的时候提供一个默认的文件名，
         * inline 和 attachment ：
         *      文件直接在浏览器上显示或者在访问时弹出文件下载对话框。
         *      inline 表示：内嵌显示，文本和图片都可以解析，但对于文件或者视频会自动去调用成attachment，因此可以直接使用inline
         *      attachment：弹出下载框
         * URLEncoder 对象，将在响应回去的头，里面所代码filename的编码格式，转换为与客户端的一致的编码格式
         *      URLEncoder.encode(filenameValue,"utf-8"); 将Response响应到浏览器客户端为filenameValue的文件名，转变为utf-8的编码格式
         */
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filenameValue, "utf-8"));  //设置输出(下载)的文件的默认文件名为filenameValue的值，inline表示内嵌文本和图片
        /**7. 输出文件(下载文件)
         * 7.1 通过 new，创建字节输入流 FileInputStream，读取文件
         * 7.2 通过Response域，创建Servlet的输出流，输出文件
         * */
        FileInputStream fileInputStream = new FileInputStream(realPath);
        ServletOutputStream outputStream = resp.getOutputStream();
        int b = 0;
        byte[] by = new byte[1024 * 8];
        while ((b = fileInputStream.read(by)) != -1) {
            outputStream.write(by, 0, b);
        }
        outputStream.flush();
        fileInputStream.close();
        outputStream.close();  //关流，response获得流会自动关闭，因此也可以不用手动关
    }
}
