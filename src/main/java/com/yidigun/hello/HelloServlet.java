package com.yidigun.hello;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/plain; charset=UTF-8");

        PrintWriter out = new PrintWriter(new OutputStreamWriter(res.getOutputStream()));
        out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));

        out.close();
    }
}
