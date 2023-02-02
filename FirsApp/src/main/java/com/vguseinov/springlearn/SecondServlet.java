package com.vguseinov.springlearn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/shop"})
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    hello dear\n" + req.getParameter("userName") +
                "    <form action=\"/bill\" method=\"get\">\n" +
                "        <input type=\"submit\" value=\"go to the third page\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
        req.getSession().setAttribute("name", req.getParameter("userName"));
    }
}
