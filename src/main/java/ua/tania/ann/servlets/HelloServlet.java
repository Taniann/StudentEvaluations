package ua.tania.ann.servlets;

/**
 * Created by Таня on 25.07.2018.
 */
import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        httpServletResponse.getWriter().print("Hello from my servlet");
    }
}