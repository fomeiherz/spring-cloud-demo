package top.fomeiherz.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// name 配置服务名称
@FeignClient(name = "service-two")
public interface TestFeignClient {

    @RequestMapping(value = "/addition", method = RequestMethod.GET)
    String addition(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
