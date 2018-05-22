package site.haiyang.apiclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.haiyang.apiclient.client.ProductClient;

@RestController
public class ProductController {

    @Autowired
    private ProductClient productClient;

    @RequestMapping("productListClient")
    public String productListClient(){
        String fromAddress = productClient.productList();
        System.out.println(fromAddress);
        return fromAddress;
    }

}
