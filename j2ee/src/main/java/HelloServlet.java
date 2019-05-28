
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    //      public void doGet(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            response.getWriter().println("<h1>Hello Servlet!</h1>");
//            response.getWriter().println(new Date().toString());
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("pragma", "no-cache");
            response.getWriter().println("<h1>Hello Servlet!</h1>");
            response.getWriter().println(new Date().toString());
            response.setStatus(301);
            response.setHeader("Location", "fail.html");

//          PrintWriter pw=response.getWriter();
//          pw.println("<h1>第一次调用 Servlet</h1>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}