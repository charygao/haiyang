package site.haiyang.apiclient.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(serviceId = "hmall")
public interface ProductClient {
    @RequestMapping(value="/productList")
    public String productList();
}
