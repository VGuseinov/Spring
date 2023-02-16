package com.vguseinov.springlearn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/shop"})
public class Shop extends HttpServlet {
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
                "    <h1>Hello\n" + req.getSession().getAttribute("name") + "</h1>" +
                "        <h2>" + TotalCounter.getList(req.getParameter("things")) + "</h2>\n" +
                "        <select name=\"things\">\n" +
                "            <option>Book 2$</option>\n" +
                "            <option>Iphone 1500$</option>\n" +
                "            <option>Desk 100$</option>\n" +
                "            <option>PlayStation 5 1000$</option>\n" +
                "            <option>Headphone 150$</option>\n" +
                "            <option>BMW 32000$</option>\n" +
                "        </select>\n" +
                "        <input type=\"submit\" value=\"add order\">\n" +
                "    </form>\n" +
                "    <form action=\"/total\" method=\"get\">\n" +
                "        <input type=\"submit\" value=\"submit\"></input>\n" +
                "    </form>\n" +
                "</center>\n" +
                "</body>\n" +
                "</html>");
    }
}
