package cn.wanxi.manage.web.util;

import net.sf.json.JSONObject;

import java.net.InetAddress;
import java.util.Map;
import java.util.Properties;

/**
 * @program: takeoutrearestaurant
 * @description: 获取电脑信息
 * @author: Wu Guo
 * @create: 2019-09-04 09:38
 */
public class getComputerInfoUtil {

    private static void getIpconfig() {
        Map<String, String> map = System.getenv();
        System.out.println(map.get("USERNAME"));//获取用户名
        System.out.println(map.get("COMPUTERNAME"));//获取计算机名
        System.out.println(map.get("USERDOMAIN"));//获取计算机域名
    }

    private static void Config(){
        try{
            InetAddress addr = InetAddress.getLocalHost();
            String ip=addr.getHostAddress().toString(); //获取本机ip
            String hostName=addr.getHostName().toString(); //获取本机计算机名称
            System.out.println("本机IP："+ip+"\n本机名称:"+hostName);
            Properties props=System.getProperties();
            System.out.println("操作系统的名称："+props.getProperty("os.name"));
            System.out.println("操作系统的版本："+props.getProperty("os.version"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void all(){
        Runtime r = Runtime.getRuntime();
        Properties props=System.getProperties();
        System.out.println("Java的运行环境版本："+props.getProperty("java.version"));
//        System.out.println("Java的运行环境供应商："+props.getProperty("java.vendor"));
//        System.out.println("Java供应商的URL："+props.getProperty("java.vendor.url"));
        System.out.println("Java的安装路径："+props.getProperty("java.home"));
//        System.out.println("Java的虚拟机规范版本："+props.getProperty("java.vm.specification.version"));
//        System.out.println("Java的虚拟机规范供应商："+props.getProperty("java.vm.specification.vendor"));
//        System.out.println("Java的虚拟机规范名称："+props.getProperty("java.vm.specification.name"));
//        System.out.println("Java的虚拟机实现版本："+props.getProperty("java.vm.version"));
//        System.out.println("Java的虚拟机实现供应商："+props.getProperty("java.vm.vendor"));
//        System.out.println("Java的虚拟机实现名称："+props.getProperty("java.vm.name"));

        System.out.println("JVM可以使用的总内存:    " + r.totalMemory() /1024L/1024L + "M av");
        System.out.println("JVM可以使用的剩余内存:   " + r.freeMemory()/1024L/1024L + "M av");
//        System.out.println("Java运行时环境规范版本："+props.getProperty("java.specification.version"));

//        System.out.println("Java运行时环境规范供应商："+props.getProperty("java.specification.vender"));
//        System.out.println("Java运行时环境规范名称："+props.getProperty("java.specification.name"));
//        System.out.println("Java的类格式版本号："+props.getProperty("java.class.version"));
//        System.out.println("Java的类路径："+props.getProperty("java.class.path"));
//        System.out.println("加载库时搜索的路径列表："+props.getProperty("java.library.path"));

        System.out.println("默认的临时文件路径："+props.getProperty("java.io.tmpdir"));

//        System.out.println("一个或多个扩展目录的路径："+props.getProperty("java.ext.dirs"));
        System.out.println("操作系统的名称："+props.getProperty("os.name"));
        System.out.println("操作系统的构架："+props.getProperty("os.arch"));
        System.out.println("操作系统的版本："+props.getProperty("os.version"));
//        System.out.println("文件分隔符："+props.getProperty("file.separator"));//在 unix 系统中是＂／＂ System.out.println("路径分隔符："+props.getProperty("path.separator"));//在 unix 系统中是＂:＂ System.out.println("行分隔符："+props.getProperty("line.separator"));//在 unix 系统中是＂/n＂ System.out.println("用户的账户名称："+props.getProperty("user.name"));
//        System.out.println("用户的主目录："+props.getProperty("user.home"));
//        System.out.println("用户的当前工作目录："+props.getProperty("user.dir"));
    }
//    public static void main(String[] args) {
//        all();
////        getIpconfig();
////        Config();
//    }
    public JSONObject getComputerInfo(){
        Runtime r = Runtime.getRuntime();
        Properties props=System.getProperties();
        JSONObject json=new JSONObject();
        String name=props.getProperty("os.name")+"  "+props.getProperty("os.version");
        json.put("name",name);//操作系统版本
        //replaceAll()为替代指定的字符串
        String arch=props.getProperty("os.arch").replaceAll("amd","x");
        json.put("arch",arch);//操作系统类型,
        String tmpdir=props.getProperty("java.io.tmpdir");
        json.put("tmpdir",tmpdir);//临时目录
        String version=props.getProperty("java.version");
        json.put("version",version);//JDK版本
        String home=props.getProperty("java.home");
        json.put("home",home);//JDK安装目录
        String memory=r.totalMemory()/1024L/1024L+"MB/"+r.freeMemory()/1024L/1024L + "MB";
        json.put("memory",memory);//总内存/剩余内存
        return json;
    }
}
