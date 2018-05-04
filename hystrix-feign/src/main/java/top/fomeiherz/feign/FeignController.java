package top.fomeiherz.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    public TestFeignClient testFeignClient;

    @RequestMapping(value = "/addition", method = RequestMethod.GET)
    public String addition(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return testFeignClient.addition(a,b);
    }

}
