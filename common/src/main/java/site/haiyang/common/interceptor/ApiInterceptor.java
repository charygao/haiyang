package site.haiyang.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import site.haiyang.common.basic.UtilString;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class ApiInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        
        String referer = "";  
        boolean referer_sign = true;// true 站内提交，验证通过 //false 站外提交，验证失败  
        Enumeration headerValues = request.getHeaders("referer");  
        while(headerValues.hasMoreElements()) {  
            referer = (String) headerValues.nextElement();  
        }  
        // 判断是否存在请求页面  
        if(UtilString.isEmpty(referer)) referer_sign = false;
        else{  
            // 判断请求页面和getRequestURI是否相同  
            String servername_str = request.getServerName();  
            if(!UtilString.isEmpty(servername_str)) {  
                int index = 0;  
                if(UtilString.indexOf(referer, "https://") == 0) {  
                    index = 8;  
                }  
                else if (UtilString.indexOf(referer, "http://") == 0) {  
                    index = 7;  
                }  
                if(referer.length() - index < servername_str.length()) {// 长度不够  
                    referer_sign = false;  
                }  
                else{ // 比较字符串（主机名称）是否相同  
                    String referer_str = referer.substring(index, index + servername_str.length());  
                    if(!servername_str.equalsIgnoreCase(referer_str)) referer_sign = false;  
                }  
            } else referer_sign = false;  
        }  
        return referer_sign;
    }
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub
        
    }
    
}
