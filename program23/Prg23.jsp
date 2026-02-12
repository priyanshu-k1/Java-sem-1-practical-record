<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <html>
    <head>
        <title>Prg 23</title>
    </head>
    <body>
        <h2>JSP Expression Example</h2>
        Current Date and Time: <%= new java.util.Date() %>
        <br><br>
        Addition of 10 + 20 = <%= 10 + 20 %>
        <br><br>
        Server Name: <%= request.getServerName() %>
        <br><br>
        Client IP Address: <%= request.getRemoteAddr() %>
    </body>
    </html>