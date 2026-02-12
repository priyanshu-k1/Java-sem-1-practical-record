//Write a program to demonstrate Session Management in Servlets. 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Prg22 extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        Integer count = (Integer) session.getAttribute("visitCount");

        if (count == null) {
            count = 1;
        } else {
            count = count + 1;
        }

        session.setAttribute("visitCount", count);

        out.println("<h2>Session Management Example</h2>");
        out.println("Session ID: " + session.getId() + "<br>");
        out.println("Number of Visits: " + count + "<br>");
    }
    
}

