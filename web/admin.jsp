<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin page</h1>
        <%
        User user = (User) request.getSession().getAttribute("currUser");
        if(user != null & user.getRole()==1){
            response.getWriter().print("Wecome: "+user.getUsername());
        }else{
            response.sendRedirect("login.html");
        }
        %>
        
        <a href="book.jsp">Book management</a>
    </body>
</html>
