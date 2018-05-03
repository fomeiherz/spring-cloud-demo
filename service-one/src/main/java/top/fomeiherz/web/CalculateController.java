package top.fomeiherz.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculateController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/addition", method = RequestMethod.GET)
    public String addition(@RequestParam Integer a, @RequestParam Integer b) {
        Integer result = a + b;
        ServiceInstance instance = client.getLocalServiceInstance();

        logger.info(String.format("/addition, host : %s, service_id : %s, result : %s",
                instance.getHost(), instance.getServiceId(), result));

        return "from service-one, result is " + result;
    }

    // 第一个服务调用第二个服务
    @RequestMapping(value = "/testServiceTwo", method = RequestMethod.GET)
    public String testServiceTwo(@RequestParam Integer a, @RequestParam Integer b) {
        RestTemplate template = new RestTemplate();
        return template.getForObject("http://localhost:7075/addition?a=" + a + "&b=" + b, String.class);
    }
}
