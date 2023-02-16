package com.vguseinov.springlearn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<center>\n" +
                "    <form action=\"/shop\" method=\"get\">\n" +
                "        <h1>Welcome to Online shop</h1>\n" +
                "        <div>\n" +
                "        <input type=\"text\" name=\"userName\">\n" +
                "        </div>\n" +
                "        <div>\n" +
                "        <input type=\"submit\" value=\"submit\">\n" +
                "        </div>\n" +
                "        <input type=\"checkbox\" name=\"check\">\n" +
                "        i agree\n" +
                "    </form>\n" +
                "</center>\n" +
                "</body>\n" +
                "</html>");
    }
}
