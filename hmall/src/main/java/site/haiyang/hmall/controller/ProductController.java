package site.haiyang.hmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import site.haiyang.hmall.util.UtilRedisCheckin;

@RestController
//@Controller
public class ProductController {

    @RequestMapping("productList")
//    @ResponseBody
    public String getProductList(@RequestParam String str){

        return  "this is product of hmall";
    }

    /**
     * 为了工作的测试
     * @param userId
     * @param dateStr
     * @return
     */
    @RequestMapping("signSenge")
    public String forWorkTest(Long userId,String dateStr){

        UtilRedisCheckin.putWeekCheckin(userId,dateStr);
        return "success";
    }
}
