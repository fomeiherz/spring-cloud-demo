package top.fomeiherz;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import top.fomeiherz.filter.ErrorFilter;
import top.fomeiherz.filter.FirstFilter;
import top.fomeiherz.filter.SecondFilter;

@SpringCloudApplication
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }

    @Bean
    public FirstFilter firstFilter() {
        return new FirstFilter();
    }

    // 这个过滤会有异常抛出，需要测试异常情况请打开
//    @Bean
//    public SecondFilter secondFilter() {
//        return new SecondFilter();
//    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }

}
