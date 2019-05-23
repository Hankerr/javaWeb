import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "Login")
public class LoginServlet extends HttpServlet {
    //    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//
//    @Override
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            String name = request.getParameter("name");
//            String password = request.getParameter("password");
//
//            String html=null;
//            if("admin".equals(name)&&"123".equals(password)){
//                html = "<div style='color:green'>success</div>";
//            }else{
//                html = "<div style='color:red'>fail</div>";
//            }
//            PrintWriter pw=response.getWriter();
//            pw.printf(html);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    //LoginServlet构造方法
    public LoginServlet() {
        System.out.printf("实例化Servlet对象(只一次,单例模式)\n");
    }

    //init方法 实例方法
    public void init(ServletConfig config) {
        System.out.printf("init(ServletConfig)被调用(只一次,单例模式)\n");

    }

    //service方法，执行doGet方法和doPost方法
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置中文格式接收请求
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name);
        System.out.println("请求登陆的url为：" + request.getRequestURL());
        System.out.println("请求部分资源，去掉去掉协议和主机名：" + request.getRequestURI());
        System.out.println("请求行的参数部分：" + request.getQueryString());
        System.out.println("浏览器所处的客户的IP地址：" + request.getRemoteAddr());
        System.out.println("浏览器所处的客户的主机名：" + request.getRemoteHost());
        System.out.println("浏览器所处客户使用的网络端口：" + request.getRemotePort());
        System.out.println("服务器的IP：" + request.getLocalAddr());
        System.out.println("服务器的主机名：" + request.getLocalName());
        System.out.println("得到浏览器的请求方式:" + request.getMethod());
        String html = null;

        if ("admin".equals(name) && "123".equals(password))
            //html = "<div style='color:green'>登录成功</div>";
            //跳转成功登陆页面
            request.getRequestDispatcher("success.html").forward(request, response);
        else
            //html = "<div style='color:red'>登录失败</div>";
            response.sendRedirect("fail.html");

        //设置返回响应为中文格式
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter pw = response.getWriter();
        pw.println(html);
    }

    public void destroy() {
        System.out.printf("destroy方法被执行\n");
    }
}
