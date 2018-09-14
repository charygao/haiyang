package site.haiyang.common.http;

import site.haiyang.common.basic.UtilString;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public class UtilSystemProperties {
      
    public static String getIPWLan() throws IOException {  
        InputStream ins = null;  
        try {  
            URL url = new URL("http://1212.ip138.com/ic.asp");  
            URLConnection con = url.openConnection();  
            ins = con.getInputStream();  
            InputStreamReader isReader = new InputStreamReader(ins, "GB2312");  
            BufferedReader bReader = new BufferedReader(isReader);  
            StringBuffer webContent = new StringBuffer();  
            String str = null;  
            while ((str = bReader.readLine()) != null) {  
                webContent.append(str);  
            }  
            int start = webContent.indexOf("[") + 1;  
            int end = webContent.indexOf("]");  
            return webContent.substring(start, end);  
        } finally {  
            if (ins != null) {  
                ins.close();  
            }  
        }  
    }  
  
    public static String getIPLocal() throws IOException {  
        InetAddress ia = InetAddress.getLocalHost();  
        return ia.getHostAddress();  
    }
    
    //获取来访者ip
    public static String getIPByClient(HttpServletRequest request){
                
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }
        if (!UtilString.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }else{
            return "无法获取用户IP";
        }
    }
    
 // 0xa -- "10.0.0.0">>24; 0xc0a8--"192.168.0.0.">>16; 0x2b0--"127.17.0.1">>22
    static int isInnerIP( int a_ip )
    {
           int bValid = -1;
           if( (a_ip>>24 == 0xa) || (a_ip>>16 == 0xc0a8) || (a_ip>>22 == 0x2b0) )
           {
              bValid = 0;
           }
           return bValid;
    }
    
    public static void main(String[] args) {  
//        try {  
//            String ip1 = getIPWLan();  
//            System.out.println("myIP:" + ip1);  
//            String ip2 = getIPLocal();  
//            System.out.println("myLocalIP:" + ip2);  
//        } catch (IOException e1) {  
//            e1.printStackTrace();  
//        }  
    	String enterpriseId = "1";
    	String uid = "1";
    	String ip = "12345";
    	System.out.println("{\"enterpriseid\":" + enterpriseId + ",\"uid\":" + uid + ",\"loginip\":\"" + ip + "\",\"ip\":\"" + ip +"\"}");
    }  
}
