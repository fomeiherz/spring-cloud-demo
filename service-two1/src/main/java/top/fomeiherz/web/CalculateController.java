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

import javax.servlet.http.HttpServletRequest;

@RestController
public class CalculateController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public String addition(@RequestParam Integer a, @RequestParam Integer b, HttpServletRequest request) {
        logger.info(request.getRequestURL());
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        Integer result = a + b;

        logger.info(String.format("/addition, host : %s, service_id : %s, result : %s",
                instance.getHost(), instance.getServiceId(), result));

        return String.format("from service-two1 result is %s, port is %s", result, instance.getPort());
    }

    @RequestMapping(value = "/testServiceOne", method = RequestMethod.GET)
    public String testServiceOne(@RequestParam Integer a, @RequestParam Integer b) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:7074/addition?a=" + a + "&b=" + b, String.class);
    }

}
