package site.haiyang.hmall;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestForSenge {

    public static void main(String[] args) throws UnsupportedEncodingException {

        Cookie cookie = new Cookie("senge","helloworld");
        System.out.println(String.format("对象是：%s,对象的属性%s值是：%s",cookie.toString(),cookie.getName(),cookie.getValue()));

        System.out.println(URLDecoder.decode("xxxx","utf-8"));
    }
}
