package top.fomeiherz.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;
import top.fomeiherz.constants.FilterConstants;

import javax.servlet.http.HttpServletRequest;

public class SecondFilter extends ZuulFilter {

    private static Logger log = Logger.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //HttpServletResponse response = ctx.getResponse();

        log.info("第二级过滤器！");

        log.info("===============");

        throw new RuntimeException("第二级过滤器异常");


//        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
//        System.out.println(request.getRequestURL());
    }
}
