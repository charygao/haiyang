package site.haiyang.common.util;

import com.alibaba.fastjson.JSONObject;
import site.haiyang.common.basic.UtilString;
import site.haiyang.common.http.UtilHttpClient;

import java.util.List;

public class UtilLocation {
    
    /**
     * 使用百度地图的api
    * @return
    * @author yanghaiyang   
    * @date 2016年11月14日 下午2:52:26
     */
    public static String getLocationByIp(){

        JSONObject jsonO = new JSONObject();
        jsonO.put("ak", "SPFr1n9Z0441UbpXY6INgRG91v4W2jUa");
//        http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=58.247.112.82
//        http://ip.taobao.com/instructions.php
//        http://ip.taobao.com/service/getIpInfo.php?ip=210.75.225.254
        String localStr = UtilHttpClient.getPostResponse(jsonO.toJSONString(), "http://api.map.baidu.com/location/ip");
        return localStr;
    }
    
    public static String getLocationByIp(String ip){

        if(UtilString.isEmpty(ip))
            return "ip 不能为空";
        JSONObject jsonO = new JSONObject();
        jsonO.put("ak", "SPFr1n9Z0441UbpXY6INgRG91v4W2jUa");
        jsonO.put("ip", ip);
        String localStr = UtilHttpClient.getPostResponse(jsonO.toJSONString(), "http://api.map.baidu.com/location/ip");
        System.out.println(localStr);
        return localStr;
    }
    
    /**
    * @Description 获取详细地址信息  
    * @return
    * @author yanghaiyang   
    * @date 2016年11月14日 下午3:13:43
     */
    public static String getAddrDetail(){
        
        String allStr = getLocationByIp();
        JSONObject firstJ  = JSONObject.parseObject(allStr);
        String content = String.valueOf(firstJ.get("content"));  //创建可控制层数Object来处理
        JSONObject twoJ = JSONObject.parseObject(content);
        String addrDetail =  String.valueOf(twoJ.get("address_detail"));
        return addrDetail;
    }
    
 public static String getAddrDetail(String ip){
        
        String allStr = getLocationByIp(ip);
        JSONObject firstJ  = JSONObject.parseObject(allStr);
        String content = String.valueOf(firstJ.get("content"));  //创建可控制层数Object来处理
        JSONObject twoJ = JSONObject.parseObject(content);
        String addrDetail =  String.valueOf(twoJ.get("address_detail"));
        return addrDetail;
    }
    
    public static String getCity(){
        
        String addrDetail = getAddrDetail();
        JSONObject jO = JSONObject.parseObject(addrDetail);
        String city = (String)jO.get("city");
        return city;
    }
    
    public static void main(String[] args) {
        
//        getLocationByIp();
        getLocationByIp("120.25.153.197");
    	
    	
    }
    
    class jsonToObject{
        
        private List<Object> object;
        void init(){
            object = null;
            System.out.println(object);
        }
    }

}
