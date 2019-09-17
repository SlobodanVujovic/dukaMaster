package com.mds.dukamaster.business;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author svujovic
 */
@WebFilter(urlPatterns = {"/*"})
public class CorsFilter implements Filter {

    public static final String ALLOWED_METHODS = "GET, POST, PUT, DELETE, OPTIONS, HEAD";
    public final static Integer MAX_AGE = 24 * 60 * 60;
    public final static String DEFAULT_ALLOWED_HEADERS = "origin,accept,content-type";
    public final static String DEFAULT_EXPOSED_HEADERS = "location,info";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", getRequestedAllowedHeaders(servletRequest));
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Expose-Headers", getRequestedExposedHeaders(servletRequest));
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Credentials", "true");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods", ALLOWED_METHODS);
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Max-Age", MAX_AGE.toString());
        ((HttpServletResponse) servletResponse).addHeader("x-responded-by", "cors-response-filter");

        //Pass the request along the filter chain.
        chain.doFilter(servletRequest, servletResponse);
    }

    String getRequestedAllowedHeaders(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Enumeration<String> headers = request.getHeaders("Access-Control-Allow-Headers");
        return createHeaderList(headers, DEFAULT_ALLOWED_HEADERS);
    }

    String getRequestedExposedHeaders(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Enumeration<String> headers = request.getHeaders("Access-Control-Expose-Headers");
        return createHeaderList(headers, DEFAULT_EXPOSED_HEADERS);
    }

    String createHeaderList(Enumeration<String> headers, String defaultHeaders) {
        if (!headers.hasMoreElements()) {
            return defaultHeaders;
        }
        StringBuilder retVal = new StringBuilder();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            retVal.append(header);
            retVal.append(',');
        }
        retVal.append(defaultHeaders);
        return retVal.toString();
    }
}
