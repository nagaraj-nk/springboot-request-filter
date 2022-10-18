package com.srjons.filters.filter;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CountryFilter implements Filter {

    List<String> ALLOWED_APP_ID_LIST = List.of("123", "124", "125");

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        /*byte[] bytes = httpServletRequest.getInputStream().readAllBytes();
        String reqData = new String(bytes);
        JSONObject jsonObject = new JSONObject(reqData);*/
        //String appId = jsonObject.getString("APP_ID");
        String appId = httpServletRequest.getParameter("app_id");
        if (!ObjectUtils.isEmpty(appId) && ALLOWED_APP_ID_LIST.contains(appId)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
