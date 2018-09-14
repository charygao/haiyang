package site.haiyang.common.message;

import com.alibaba.fastjson.JSONObject;
import site.haiyang.common.enumeration.EnumSmsTemplate;
import site.haiyang.common.returnobject.ReturnObject;
import site.haiyang.common.vo.ObjectParam;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.net.URISyntaxException;

public class UtilSMS {

//    /**  
//     * @description 返回信息为result 标识，为int类型
//    * @param phone 手机号码
//    * @param content 模板内容
//     */
//    public static HashMap<String, Object> sendSMS(String phone, String content) throws ClientProtocolException, IOException, URISyntaxException {
//        
//            HashMap<String, Object> map  = new HashMap<String, Object>();
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("SpCode", "222547");
//            jsonObject.put("LoginName", "gd_zy");
//            jsonObject.put("Password", "ML1R9S8Y@");
//            jsonObject.put("UserNumber",phone);
//            //调用短信模板
//            boolean isHaveTem = false;
//            String noneStr = String.valueOf((int)((Math.random()*9+1)*100000));
//            for (EnumSmsTemplate enumSmsTemplate : EnumSmsTemplate.values()) {
//                if(content.equals(enumSmsTemplate.name())){
//                    String temStr = enumSmsTemplate.getValue();
//                    if(enumSmsTemplate.name().equals(EnumSmsTemplate.valiCode.name()))
//                        temStr = temStr.replace("x",noneStr);
//                    jsonObject.put("MessageContent",temStr);
//                    isHaveTem = true;
//                }
//            }
//            if(!isHaveTem) {
//                map.put("result", "result=28&description=发送内容与模板不符");
//                return map;
//            }
//            String response = UtilHttpClient.getPostResponseBySms(JSON.toJSONString(jsonObject), EnumHost.smsHost.getValue());
//            //随机码
//            map.put("noneStr", noneStr);
//            map.put("result", response);
//            return map; 
//    }
    
    public static String getByteString( byte[] buff_out )
    {
        StringBuffer strBuf = new StringBuffer(buff_out.length * 3);
        strBuf.append("Length[");
        strBuf.append(buff_out.length);
        strBuf.append("];Content[");
        for ( int i = 0 ; i < buff_out.length ; ++i ) {
            int l = buff_out[i] & 0x0F;
            int h = (buff_out[i] & 0xF0) >> 4;

            char ll = (char) (l > 9 ? 'a' + l - 10 : '0' + l);
            char hh = (char) (h > 9 ? 'a' + h - 10 : '0' + h);

            strBuf.append(hh);
            strBuf.append(ll);
            strBuf.append(" ");
        }
        strBuf.append("]");
        return strBuf.toString().toUpperCase();
    }
    
    
    /**  
     * @description 返回信息为result 标识，为int类型
    * @param phone 手机号码
    * @param content 模板内容
     */
    public static ReturnObject<ObjectParam> sendSMS(String phone, String content) throws ClientProtocolException, IOException, URISyntaxException {
        
            ReturnObject<ObjectParam> returnObject = new ReturnObject<ObjectParam>();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("SpCode", "222547");
            jsonObject.put("LoginName", "gd_zy");
            jsonObject.put("Password", "ML1R9S8Y@");
            jsonObject.put("UserNumber",phone);
            //调用短信模板
            boolean isHaveTem = false;
            String temStr = null;
            String noneStr = String.valueOf((int)((Math.random()*9+1)*100000));
            for (EnumSmsTemplate enumSmsTemplate : EnumSmsTemplate.values()) {
                if(content.equals(enumSmsTemplate.name())){
                    temStr = enumSmsTemplate.getValue();
                    if(enumSmsTemplate.name().equals(EnumSmsTemplate.valiCode.name()))
                        temStr = temStr.replace("x",noneStr);
                    jsonObject.put("MessageContent",temStr);
                    isHaveTem = true;
                }
            }
            if(!isHaveTem) {
                returnObject.setMsg("发送内容与模板不符");
                returnObject.setSuccess(false);
            }
            if(returnObject.getSuccess()){
                ObjectParam op = new ObjectParam();
                JSONObject jsonObjectP = new JSONObject();
                jsonObjectP.put("phone", phone);
                jsonObjectP.put("content", temStr);
                op.setKey("yishang.sms.send");
                op.setArgs(jsonObjectP.toJSONString());
                returnObject.setResult(op);
                returnObject.setReturn_code(Integer.valueOf(noneStr));
            }
            return returnObject; 
    }

}
