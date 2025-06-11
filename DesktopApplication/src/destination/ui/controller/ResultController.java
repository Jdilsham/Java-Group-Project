
package destination.ui.controller;
import java.sql.*;
import Connection.DBConnection;
//import com.mysql.jdbc.Connection;
import destination.CheckDestination;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class ResultController {

    public void getResults(String destination, DefaultTableModel tableModel) throws SQLException {
            CheckDestination check=new CheckDestination(destination, DBConnection.getConnection());
            check.display(tableModel);
          
    }
    
    
}


