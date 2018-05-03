package top.fomeiherz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TwoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TwoApplication.class).web(true).run(args);
    }

}
