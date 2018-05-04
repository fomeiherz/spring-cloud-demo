package top.fomeiherz.filter;

import com.netflix.zuul.ZuulFilter;
import org.apache.log4j.Logger;
import top.fomeiherz.constants.FilterConstants;

public class RouteFilter extends ZuulFilter {

    private static Logger log = Logger.getLogger(RouteFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        // RequestContext ctx = RequestContext.getCurrentContext();
        // HttpServletRequest request = ctx.getRequest();
        // HttpServletResponse response = ctx.getResponse();

        log.info("进入链路的过滤器！");

        log.info("===============");

//        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
//        System.out.println(request.getRequestURL());

//        Object accessToken = request.getParameter("accessToken");
//        if(accessToken == null) {
//            log.warn("access token is empty");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            return null;
//        }
//        log.info("access token ok");

        return null;
    }
}
