package com.bee.airsystem.utils;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author ：Bee
 * @date ：Created in 2020/6/1 20:32
 */
public class RequestUtils {

    /**
     * 转发请求
     *
     * @param path     请求路径
     * @param request  请求对象
     * @param response 响应对象
     * @throws ServletException if the target resource throws this exception
     * @throws IOException      if the target resource throws this exception
     */
    public static void forward(String path, ServletRequest request, ServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(path).forward(request, response);
    }

}
