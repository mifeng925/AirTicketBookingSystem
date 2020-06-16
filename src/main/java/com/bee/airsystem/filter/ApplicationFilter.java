package com.bee.airsystem.filter;

import com.bee.airsystem.entity.UserBase;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/15 10:04
 */
@WebFilter(urlPatterns = "/*")
public class ApplicationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String servletPath = request.getServletPath();

        if ("/login".equals(servletPath) || "/register".equals(servletPath) ||"/captcha".equals(servletPath)
                || servletPath.startsWith("/plugins/") || servletPath.startsWith("/dist/")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            UserBase user = (UserBase) request.getSession().getAttribute("user");
            if (user != null) {
                request.setAttribute("path", servletPath);

                if (user.getPower() > 3) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    if ("/planes".equals(servletPath) || "/flight".equals(servletPath)) {
                        ((HttpServletResponse) servletResponse).sendRedirect("./main");
                    } else {
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
                }


            } else {
                ((HttpServletResponse) servletResponse).sendRedirect("./login");
            }
        }

    }

    @Override
    public void destroy() {

    }
}
