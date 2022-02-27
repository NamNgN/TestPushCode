
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.UserDAO;

/**
 *
 * @author thopn
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        // Lay du lieu tu Form login
        String user = request.getParameter("txtUser");
        String pass = request.getParameter("txtPass");
        //out.print(user + ", " + pass);
        User objUser = null;
        objUser = new UserDAO().getUser(user, pass);
        
        if(objUser == null){
            // Dieu huong ve index.html. Dong thoi, hien thi thong diep tren Form
            // "Username /or password is/are invalid. Try again!"
            out.print("<h4 style='color:red'>Username /or password is/are invalid.</h4>");
            request.getRequestDispatcher("login.html").include(request, response);
            out.print("<h4>Please, try again.</h4>");
        }else{
            // Cap phien lam viec (Session). Sau do, dieu huong toi welcome.jsp
            request.getSession().setAttribute("currUser", objUser);
            if(objUser.getRole()==1)
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            if(objUser.getRole()==3)
                request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }

}
