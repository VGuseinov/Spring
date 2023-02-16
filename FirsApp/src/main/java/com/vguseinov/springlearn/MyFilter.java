

package com.vguseinov.springlearn;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/shop"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.getSession().setAttribute("name", request.getParameter("userName"));
        if (request.getSession().getAttribute("UserName") == null) {
            TotalCounter.setUserName(request, request.getParameter("UserName"));
        } else if (request.getParameter("UserName") != null && !request.getSession().getAttribute("UserName").equals(request.getParameter("UserName"))) {
            request.getSession().invalidate();
            TotalCounter.setUserName(request, request.getParameter("UserName"));
        }
        if (request.getSession().getAttribute("check") == null) {
            if (request.getParameter("check") == null) {
                String path = "/error";
                ServletContext servletContext = request.getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
                requestDispatcher.forward(request, servletResponse);
            } else {
                TotalCounter.setCheckStatus(request, request.getParameter("check"));
            }
        }
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
    }
}




