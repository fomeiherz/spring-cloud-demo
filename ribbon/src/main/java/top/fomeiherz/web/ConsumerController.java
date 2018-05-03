package top.fomeiherz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/addition", method = RequestMethod.GET)
    public String addition(@RequestParam Integer a, @RequestParam Integer b) {
        loadBalancerClient.choose("service-two");

        return restTemplate.getForEntity("http://service-two/addition?a="+a+"&b="+b, String.class).getBody();
    }

}
