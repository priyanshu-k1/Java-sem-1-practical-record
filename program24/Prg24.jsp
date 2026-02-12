<%@ page language="java" contentType="text/html; charset=UTF-8" %>

    <html>
    <head>
        <title>JSP Scriptlet Demo</title>
    </head>
    <body>
        <h2>JSP Scriptlet Example</h2>
        <% for(int i=1; i <=5; i++) { out.println("Number: " + i + " <br>");
            }
            String name = "Avanthi Pg";
            out.println("Welcome to" + name);
        %>
    </body>
    </html>