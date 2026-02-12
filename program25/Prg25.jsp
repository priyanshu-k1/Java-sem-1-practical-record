<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date" %>

<html>
    <head>
        <title>Prg:25 JSP Directives & Declarations Demo</title>
    </head>
    <body>
        <h2>Directives & Declarations</h2>
            <%! int count=0; public int increment() { return ++count; } %>
                Current Date and Time: <%= new Date() %>
            <br><br>
            Visitor Count: <%= increment() %>
    </body>
</html>