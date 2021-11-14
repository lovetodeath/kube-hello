package com.yidigun.hello;

import com.sun.management.OperatingSystemMXBean;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class UptimeServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();

        res.setContentType("text/plain; charset=UTF-8");

        PrintWriter out = new PrintWriter(new OutputStreamWriter(res.getOutputStream()));
        out.printf("JVM Uptime(sec): %.2f\n", runtime.getUptime() / 1000.0);
        out.printf("JVM CPU Load(%%): %.2f\n", os.getProcessCpuLoad() * 100.0);
        out.printf("System CPU Load(%%): %.2f\n", os.getSystemCpuLoad() * 100.0);
        out.printf("System Load Average(%%/min): %.2f\n", os.getSystemLoadAverage() * 100.0);

        out.close();
    }
}
