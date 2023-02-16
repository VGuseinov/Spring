package com.vguseinov.springlearn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = ("/total"))
public class Total extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<center>" +
                " Dear " + req.getSession().getAttribute("name") + ", your order:\n" +
                "\n" +
                "<div>" + TotalCounter.getThings(req.getParameterValues("things")) +
                "Total " + TotalCounter.getSum(req.getParameterValues("things")) +
                "</div>" +
                "</center>" +
                "</body>\n" +
                "</html>");
    }
}
