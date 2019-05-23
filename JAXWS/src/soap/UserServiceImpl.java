package soap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Holder;

@WebService(endpointInterface = "soap.UserService")  
public class UserServiceImpl implements UserService {

	@Override
	public boolean register(String email, String username, String password) {
		String url = "jdbc:sqlite:D://Facultate/users.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (email, username, password) VALUES (?, ?, ?)");
            pstmt.setString(1, email);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
            //System.out.println(e.getMessage());
        }
		return false;
	}

	@Override
	public boolean changePassword(String email, String olderPassword, String newPassword) {
		String url = "jdbc:sqlite:D://Facultate/users.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET password = ? WHERE email=? AND password=?");
            pstmt.setString(1, newPassword);
            pstmt.setString(2, email);
            pstmt.setString(3, olderPassword);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
            //System.out.println(e.getMessage());
        }
		return false;
	}
	
	@Override
	public void findUser(String in_username, Holder<Integer> id, Holder<String> username) {
		String url = "jdbc:sqlite:D://Facultate/users.db";
        Connection conn = null;
        id.value=null;
        username.value=null;
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? LIMIT 1");
            pstmt.setString(1, in_username);
            ResultSet rs  = pstmt.executeQuery();
            while(rs.next()){
            	id.value=rs.getInt("id");
            	username.value=rs.getString("username");
            }
        } catch (Exception e) {
        	e.printStackTrace();
            //System.out.println(e.getMessage());
        }
	}

}
