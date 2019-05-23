package soap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.xml.ws.Holder;

public class ImageServiceImpl implements ImageService {

	@Override
	public String getImageData(Integer id) {
		String url = "jdbc:sqlite:D://Facultate/posts.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM posts WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
            	return rs.getString("source");
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
            //System.out.println(e.getMessage());
        }
        return "";
	}

	@Override
	public void getImages(Integer page, Holder ids, Holder sources) {
		String url = "jdbc:sqlite:D://Facultate/posts.db";
        Connection conn = null;
        ids.value=new ArrayList<Integer>();
        sources.value=new ArrayList<String>();
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM posts WHERE LIMIT 10 OFFSET ?");
            pstmt.setInt(1, page);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
            	((ArrayList)ids.value).add(rs.getInt("id"));
            	((ArrayList)sources.value).add(rs.getString("source"));
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
            //System.out.println(e.getMessage());
        }

	}
	
	@Override
	public Integer getNumberOfPages() {
		String url = "jdbc:sqlite:D://Facultate/posts.db";
        Connection conn = null;
        Integer pages = 0;
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement("SELECT count(id) as pagenumber FROM posts");
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
            	return rs.getInt("pagenumber");
            }
        } catch (Exception e) {
        	e.printStackTrace();
            //System.out.println(e.getMessage());
        }
		return 0;
	}

}
