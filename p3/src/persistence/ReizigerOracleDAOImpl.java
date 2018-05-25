package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import domain.Reiziger;

public class ReizigerOracleDAOImpl extends OracleBaseDAO implements ReizigerDAO {

	public ArrayList<Reiziger> findAll() {
		ArrayList<Reiziger> reizigerList = new ArrayList<Reiziger>();
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM reiziger");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String tussenvoegsel = null;
				String geboortedatum = null;
				int reizigerID = rs.getInt("reiziger_id");
				String voorletters = rs.getString("voorletters");
				if(rs.getString("tussenvoegsel") != null) {
					tussenvoegsel = rs.getString("tussenvoegsel");
				}
				String achternaam = rs.getString("achternaam");
				if(rs.getString("geboortedatum") != null) {
					geboortedatum = rs.getString("geboortedatum");
				}
				Reiziger reiziger = new Reiziger(reizigerID, voorletters, tussenvoegsel, achternaam, geboortedatum);
				reizigerList.add(reiziger);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return reizigerList;
	}

	public ArrayList<Reiziger> findByGBdatum(String GBdatum) {
		return null;
	}

	public Reiziger save(Reiziger reiziger) {
		return null;
	}

	public Reiziger update(Reiziger reiziger) {
		return null;
	}

	public boolean delete(Reiziger reiziger) {
		return false;
	}
}