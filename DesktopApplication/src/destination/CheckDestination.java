
package destination;

import java.sql.*;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class CheckDestination {
    public String name;
    private final Connection conn;

    public CheckDestination(String name,Connection conn) {
        this.conn=conn;
        this.name=name;
    }
    
   
    
    public void display(DefaultTableModel tableModel) throws SQLException{
       
        String sql="select Name,Bookings,Id from destination where Region=?";
        PreparedStatement psmt= conn.prepareStatement(sql);
        
        
            psmt.setString(1,name);
            ResultSet rs= psmt.executeQuery();
            
            while(rs.next()){
                tableModel.addRow(new Object[]{rs.getString("Name"),rs.getInt("Bookings")});
                 
    }}
}
