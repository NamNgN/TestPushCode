
package model;

import java.sql.SQLException;

public class UserDAO extends DAO{
    public User getUser(String user, String pass){
        String sql = "SELECT * FROM Users WHERE username=? AND password=?";
        User objUser = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
                int role = rs.getInt("role");
                objUser = new User(user, pass, role);
            }else{
                objUser = null;
                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
        }
        return objUser;
    }
}
