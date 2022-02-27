<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book management page</h1>
        <%
            User user = (User) request.getSession().getAttribute("currUser");
            if(user != null & user.getRole()==1){
        %>
        
        <a href="addBook.jsp">Add new Book</a>
        <a href="searchBook.jsp">Advanced search</a>
        <%
            }else{
                response.sendRedirect("login.html");
            }
        %>
    </body>
</html>
