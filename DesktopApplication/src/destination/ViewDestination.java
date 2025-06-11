package destination;

import java.sql.*;
/*import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;*/
import destination.ui.ViewDetails;
//import java.sql.SQLException;
//import java.sql.DriverManager;

public class ViewDestination {
    private static Connection conn;
    private final String name;
    
    public ViewDestination(Connection conn, String name) {
        this.name = name;
        ViewDestination.conn = conn;
    }
    
    ViewDetails detailsFrame = new ViewDetails();
     
    public void showDetails() throws SQLException{
        String sql="select * from destination where Name=?";
        
        try {
            PreparedStatement psmt= conn.prepareStatement(sql);
            psmt.setString(1,name);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
               
                detailsFrame.setInformation(rs.getString("name"),rs.getString("Description"), rs.getInt("Bookings"), rs.getString("Activities"));
                detailsFrame.setVisible(true);
            }
            
        } catch(SQLException error) {
            System.out.println(error.getMessage());
        }
    }
}
