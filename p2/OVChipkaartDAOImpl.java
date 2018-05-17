package p2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class OVChipkaartDAOImpl extends OracleBaseDAO implements OVChipkaartDAO {
	
	public OVChipkaartDAOImpl() {
		myConn = super.getConnection();
	}
	
	public ArrayList<OVChipkaart> findAllOVChipkaartenByReizigerID(Reiziger reizigerID) throws SQLException {
		
		Statement myStmt = myConn.createStatement();
		
		String vindOVChipkaartSQL = "SELECT * FROM ov_chipkaart " + 
				"WHERE reizigerID = " + reizigerID.getReizigerID() + "";
		
		ResultSet rs = myStmt.executeQuery(vindOVChipkaartSQL);
		ArrayList<OVChipkaart> OVChipkaarten = new ArrayList<OVChipkaart>();
		while (rs.next()) {
			OVChipkaarten.add(new OVChipkaart(
					rs.getInt("kaartNummer"),
					rs.getDate("geldigTot"),
					rs.getInt("klasse"),
					rs.getInt("saldo"),
					reizigerID));
		}
		
		return OVChipkaarten;
	}
}
