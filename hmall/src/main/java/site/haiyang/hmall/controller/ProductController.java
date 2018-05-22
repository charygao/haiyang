package site.haiyang.hmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @RequestMapping("productList")
    public String getProductList(){

        return  "this is product of hmall";
    }
}
