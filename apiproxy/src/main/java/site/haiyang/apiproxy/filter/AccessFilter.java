package site.haiyang.apiproxy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessFilter extends ZuulFilter {


    private static final Logger LOG = LoggerFactory.getLogger(AccessFilter.class);


    @Override
    public String filterType() {
        return "pre";
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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        LOG.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        
        RequestContext context = RequestContext.getCurrentContext();
        Map<String, List<String>> newParameterMap = new HashMap<String, List<String>>();
        Map<String, String[]> parameterMap = context.getRequest().getParameterMap();
        //getting the current parameter
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
          String key = entry.getKey();
          String[] values = entry.getValue();
          newParameterMap.put(key, Arrays.asList(values));
        }
        //add a new parameter
//        String ip = UtilSystemProperties.getIPByClient(request);
        String ip = "192.168.1.111";
        newParameterMap.put("ip",Arrays.asList(ip));
        context.setRequestQueryParams(newParameterMap);
        return null;
    }
}
