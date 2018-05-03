package top.fomeiherz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Two1Controller {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Two1Controller.class).web(true).run(args);
    }

}
