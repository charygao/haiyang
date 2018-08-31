package site.haiyang.hmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
//import site.haiyang.hmall.config.DataSourceConfig;

@SpringBootApplication
//@EnableDiscoveryClient   //通用的服务发现组件（zk等）
//@MapperScan("site.haiyang.*.dao")
@MapperScan("site.haiyang.hmall.mapper")
//@ComponentScan(basePackages={"site.haiyang.hmall"})
//@EnableAutoConfiguration
//@EnableConfigurationProperties(DataSourceConfig.class)
public class HmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmallApplication.class, args);
	}
}
