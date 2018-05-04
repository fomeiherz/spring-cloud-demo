package top.fomeiherz.feign;

import org.apache.log4j.Logger;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-two", fallback = TestFeignClient.HystrixClientFallback.class)
public interface TestFeignClient {

    @RequestMapping(value = "/addition", method = RequestMethod.GET)
    String addition(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    // 内部实现类
    @Component
    class HystrixClientFallback implements TestFeignClient {
        private static final Logger logger = Logger.getLogger(HystrixClientFallback.class);

        @Override
        public String addition(Integer a, Integer b) {
            HystrixClientFallback.logger.info(String.format("异常发生，进入fallback方法，接收的参数：%s  %s", a, b));
            return "服务端内部错误";
        }

    }

}
