//Write a program to explain the Life Cycle & Execution of a Servlet.
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class Prg19 extends HttpServlet{
    public void init() throws ServletException {
        System.out.println("Servlet Initialized");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Servlet Execution Phase</h2>");
    }

    public void destroy() {
        System.out.println("Servlet Destroyed");
    }
    
}
