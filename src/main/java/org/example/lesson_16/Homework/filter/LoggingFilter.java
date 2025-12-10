package org.example.lesson_16.Homework.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/cars", "/car"})
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("LoggingFilter: Request gəldi");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() { }
}
