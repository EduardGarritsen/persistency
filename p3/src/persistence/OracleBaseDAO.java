package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDAO {
	
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "eduard";
    private static final String DB_PASS = "geheim";

    protected Connection myConn = getConnection();
    
    protected Connection getConnection() {
    	
    	try {
    		Connection myConn = DriverManager.getConnection(DB_URL, 
    				DB_USER, DB_PASS);
            if (myConn != null) {
                return myConn;
            }
    	}
    	catch (SQLException ex) {
    		System.out.println("Geen Connectie :(");
    	}
    	return null;
    }
    
    public void closeConnection() {
    	
    }
}