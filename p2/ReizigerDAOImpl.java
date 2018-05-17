package p2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReizigerDAOImpl extends OracleBaseDAO implements ReizigerDAO {
	
	public ReizigerDAOImpl() {
		myConn = super.getConnection();
	}
	
	public Reiziger findReizigerByReizigerID(int ReizigerID) throws SQLException {
		
		Statement myStmt = myConn.createStatement();
		
		String vindReizigerSQL = "SELECT * FROM reiziger " + 
		"WHERE reiziger.reizigerID = " + ReizigerID;
		
		ResultSet rs = myStmt.executeQuery(vindReizigerSQL);
		Reiziger reizigertemp = null;
		while (rs.next()) {
			reizigertemp = new Reiziger(
					rs.getInt("reizigerID"),
					rs.getString("voorletters"),
					rs.getString("tussenvoegsel"),
					rs.getString("achternaam"),
					rs.getDate("gebortedatum"));
		}
		
		OVChipkaartDAO OVChipkaartDAO = new OVChipkaartDAOImpl();
		reizigertemp.setOVChipkaarten(OVChipkaartDAO.findAllOVChipkaartenByReizigerID(reizigertemp));
		System.out.println(reizigertemp);
		return reizigertemp;
	}
	
	public Reiziger findReizigerByReizigerIDWithOVChipkaart(int reizigerID) throws SQLException {
		Statement myStmt = myConn.createStatement();
		
		String vindReizigerSQL = "SELECT * FROM reiziger, ov_chipkaart " + 
				"WHERE reiziger.reizigerid = ov_chipkaart.reizigerid" + 
				"AND reiziger.reizigerid = " + reizigerID;
		
		ResultSet rs = myStmt.executeQuery(vindReizigerSQL);
		Reiziger reizigertemp = null;
		while (rs.next()) {
			if (reizigertemp == null) {
				reizigertemp = new Reiziger(
						rs.getInt("reizigerID"),
						rs.getString("voorletters"),
						rs.getString("tussenvoegsel"),
						rs.getString("achternaam"),
						rs.getDate("gebortedatum"));
			}
			reizigertemp.voegToeOVChipkaart(new OVChipkaart(
					rs.getInt("kaartNummer"),
					rs.getDate("geldigTot"),
					rs.getInt("klasse"),
					rs.getInt("saldo"),
					reizigertemp));
		}
		
		return reizigertemp;
	}
}
