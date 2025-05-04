
package destination;

import Connection.DBConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import java.util.Date;


public class BookDestination {
    private Connection conn;

    public BookDestination() {
        this.conn=(Connection) DBConnection.getConnection();
    }
    
    public void setBooking(int id, String destinationName,String name, String email, Date date, int count, String note, String guide,String nationality) throws SQLException{
        conn.setAutoCommit(false);
        String sql="Insert into Booking values(?,?,?,?,?,?,?,?,?)";
        String query="UPDATE destination SET Bookings = Bookings+1 where  UPPER(name) =?";

        PreparedStatement smt=(PreparedStatement) conn.prepareStatement(query);
        PreparedStatement psmt=(PreparedStatement) conn.prepareStatement(sql);
        
        smt.setString(1,destinationName.toUpperCase());
        psmt.setInt(1, id);
        psmt.setString(2,destinationName);
        psmt.setString(3, name);
        psmt.setString(4,email);
        psmt.setDate(5, (java.sql.Date) date);
        psmt.setInt(6, count);
        psmt.setString(7,note);
        psmt.setString(8, guide);
        psmt.setString(9,nationality);
        
        psmt.executeUpdate();
        smt.executeUpdate(); 
        
        conn.commit(); 
        conn.setAutoCommit(true);
        conn.close();
    }
    
    
}
