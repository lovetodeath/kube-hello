package com.yidigun.hello;

import com.yidigun.util.RandomInputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InfiniteServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String maxSec = req.getParameter("max");
        long maxMillis = 0;
        try {
            maxMillis = Long.parseLong(maxSec) * 1000;
        }
        catch (NumberFormatException e) {
        }

        res.setContentType("application/octet-stream");

        File zero = new File("/dev/urandom");
        InputStream in = null;
        if (zero.exists())
            in = new FileInputStream(zero);
        else
            in = new RandomInputStream(System.currentTimeMillis());
        OutputStream out = res.getOutputStream();

        long start = System.currentTimeMillis();
        byte[] buf = new byte[1024];
        int read = 0;
        while ((read = in.read(buf, 0, 1024)) >= 0) {
            out.write(buf, 0, read);
            if (maxMillis != 0 && System.currentTimeMillis() - start > maxMillis)
                break;
        }
        in.close();
        out.close();
    }
}
