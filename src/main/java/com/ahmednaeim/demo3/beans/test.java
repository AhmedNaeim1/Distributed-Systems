package com.ahmednaeim.demo3.beans;

import javax.naming.Context;
import javax.naming.InitialContext;

public class test {
    public static void main(String[] args) throws Exception {

        Context context = new InitialContext();

        Hello in = (Hello) context.lookup("Hello");
        in.getAllEmployees();
    }
}
