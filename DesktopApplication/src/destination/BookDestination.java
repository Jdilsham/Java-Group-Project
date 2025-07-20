
package destination;

import java.sql.*;
//import Connection.DBConnection;
import desktopapplication.databaseConn.DatabaseCon;
/*import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.SQLException;
import java.util.Date;*/


public class BookDestination {
    public Connection conn;

    public BookDestination() {
        this.conn = DatabaseCon.getConnection();
    }
    
    public void setBooking(int id,String destinationName,String name, String email, Date date, int count, String note, String guide,String nationality) throws SQLException{
        conn.setAutoCommit(false);
        String sql="Insert into book_destination values(?,?,?,?,?,?,?,?,?)";
        String query="UPDATE customer_data SET Booking_destination = Bookings+1 where  UPPER(name) =?";

        PreparedStatement smt= conn.prepareStatement(query);
        PreparedStatement psmt= conn.prepareStatement(sql);
        
        smt.setString(1,destinationName.toUpperCase());
        psmt.setInt(1, id);
        psmt.setString(2,destinationName);
        psmt.setString(3, name);
        psmt.setString(4,email);
        psmt.setDate(5, date);
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
