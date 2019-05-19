import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String name=request.getParameter("name");
        String password=request.getParameter("password");

        System.out.printf("name："+name);
        System.out.printf("password:"+password);
    }
}
