package top.fomeiherz.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import top.fomeiherz.entity.InterfaceLimit;
import top.fomeiherz.service.InterfaceLimitService;
import top.fomeiherz.util.RedisUtils;

@RestController
public class CalculateController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private InterfaceLimitService interfaceLimitService;
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/addition", method = RequestMethod.GET)
    public String addition(@RequestParam Integer a, @RequestParam Integer b) {

//        num.incrementAndGet();
//
//        if (num.get() <= flag) {
//	        ServiceInstance instance = client.getLocalServiceInstance();
//	        Integer r = a + b;
//	        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
//	        return "From Service-B, Result is " + r+"\nPort:"+instance.getPort();
//        }
//        return "调用次数超限，一分钟内最多只能调用10次！";

        InterfaceLimit limit = interfaceLimitService.getEntityByPri(1);
        Jedis jedis = RedisUtils.getJedis();

        // redis存的超时时间
        String timeOut = jedis.get("time_out");
        // 如果不存在或者是不等于数据库设置值
        if (!limit.getUnitTime().toString().equals(timeOut)) {
            // 重新设置超时时间
            jedis.set("time_out", limit.getUnitTime().toString());
            jedis.expire("count", limit.getUnitTime());
        }
        String count = jedis.get("count");
        if (count == null) {
            jedis.set("count", String.valueOf(0));
            jedis.expire("count", limit.getUnitTime());
        }
        // 自动 + 1 ？
        jedis.incr("count");

        if (Integer.parseInt(jedis.get("count")) <= limit.getUnitNum()) {
            ServiceInstance instance = client.getLocalServiceInstance();
            Integer result = a + b;

            logger.info(String.format("/addition, host : %s, service_id : %s, result : %s",
                    instance.getHost(), instance.getServiceId(), result));

            return String.format("from service-two result is %s, port is %s", result, instance.getPort());
        }
        return "调用次数超限";
    }

}
