package site.haiyang.apiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ApiclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiclientApplication.class, args);
	}
}
