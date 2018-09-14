package site.haiyang.common.stream;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class UtilDownload {

    /** 下载网络图片
     * @throws IOException */
   public static boolean downImg(String imgUrl,String path,  String fileName) throws IOException{
       
    // 输出的文件流  
       File sf=new File(path);  
       if(!sf.exists()){  
           sf.mkdirs();  
       }  
       InputStream is = null;
       String fullPath = sf.getPath()+File.separator+fileName;
       OutputStream os = new FileOutputStream(fullPath);  
       try {
        // 构造URL  
           URL url = new URL(imgUrl);  
           // 打开连接  
           URLConnection con = url.openConnection();  
           //设置请求超时为5s  
           con.setConnectTimeout(5*1000);  
           // 输入流  
           is = con.getInputStream();  
           // 1K的数据缓冲  
           byte[] bs = new byte[1024];  
           // 读取到的数据长度  
           int len;  
           // 开始读取  
           while ((len = is.read(bs)) != -1) {  
             os.write(bs, 0, len);  
           }  
           return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }finally{
     // 完毕，关闭所有链接  
        os.close();  
        is.close();  
    }
       
   }
}
