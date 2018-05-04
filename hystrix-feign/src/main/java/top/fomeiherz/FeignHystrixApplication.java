package top.fomeiherz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class FeignHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixApplication.class,args);
    }

}
