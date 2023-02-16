package com.vguseinov.springlearn;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class TotalCounter {
    private static String userName;
    private static String status;
    private static List<String> list = new LinkedList<>();

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(HttpServletRequest request, String userName) {

    }

    public static void setCheckStatus(HttpServletRequest request, String status) {
        request.getSession().setAttribute("check", status);
    }

    public static String getThings(String[] arr) {
        StringBuilder things = new StringBuilder("<ol>");
        for (String s : arr) {
            things.append("<li>\n" + s + "</li>\n");
        }
        return things.append("</ol>").toString();
    }

    public static String getSum(String[] arr) {
        StringBuilder thingsSum = new StringBuilder();
        BigDecimal res = BigDecimal.ZERO;
        for (String s : arr) {
            res = res.add(new BigDecimal(s.replaceAll("[\\D&&[^.]]", "")));
        }
        return thingsSum.append(res + "$").toString();
    }

    public static String getList(String string) {
        if (string == null) {
            if (list.isEmpty()) {
                return "Make your order";
            }
        } else {
            list.add(string);
        }
        StringBuilder things = new StringBuilder("<ol>");
        for (String s : list) {
            things.append("<li>\n" + s + "</li>\n");
        }

        return things.append("</ol>").toString();
    }
}
