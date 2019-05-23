import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("获取请求参数："+request.getParameter("name"));
        String[] habits=request.getParameterValues("habits");
        System.out.println("获取表单参数列表："+ Arrays.asList(habits));

    }

}
