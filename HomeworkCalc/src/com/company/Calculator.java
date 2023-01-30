package com.company;

public class Calculator {

    public static int workCalc (String str) {
        String[] arr = str.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        String s = arr[1];
        switch (s) {
            case "+":
                return a + b;
            case "-":
                return a- b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return  a / b;
                } else {
                    throw new ArithmeticException("Делить на ноль нельзя");
                }
                default:
                    System.out.println("Операция не расознана! Повторите ввод.");
        }
        return -1;
    }
}
