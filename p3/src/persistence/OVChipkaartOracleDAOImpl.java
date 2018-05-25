package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import domain.OVChipkaart;
import domain.Reiziger;

public class OVChipkaartOracleDAOImpl extends OracleBaseDAO implements OVChipkaartDAO {
	
	public ArrayList<OVChipkaart> findByReiziger(long id) {
		ArrayList<OVChipkaart> OVChipkaartList = new ArrayList<OVChipkaart>();
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM ov_chipkaart where reiziger_id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				long kaartNummer = rs.getLong("kaart_nummer");
				String geldigTot = rs.getString("geldig_tot");
				int klasse = rs.getInt("klasse");
				double saldo = rs.getDouble("saldo");
				long reizigerID = rs.getLong("reiziger_id");
				OVChipkaart oVChipkaart = new OVChipkaart(kaartNummer, geldigTot, klasse, saldo, reizigerID);
				OVChipkaartList.add(oVChipkaart);
			}
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return OVChipkaartList;
	}
	
	public OVChipkaart findById(long id) {
		try (Connection myConn = super.getConnection()) {
			PreparedStatement stmt = myConn.prepareStatement("SELECT * FROM ov_chipkaart where kaart_nummer = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				long kaartNummer = rs.getLong("kaart_nummer");
				String geldigTot = rs.getString("geldig_tot");
				int klasse = rs.getInt("klasse");
				double saldo = rs.getDouble("saldo");
				long reizigerID = rs.getLong("reiziger_id");
				OVChipkaart oVChipkaart = new OVChipkaart(kaartNummer, geldigTot, klasse, saldo, reizigerID);
				return oVChipkaart;
			}
			myConn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

	public OVChipkaart updateOVChipkaart(OVChipkaart oVChipkaart) {
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(
					"UPDATE ov_chipkaart SET geldig_tot = ?, klasse = ?, saldo = ?, reiziger_id = ? WHERE kaart_nummer = ?");
			stmt.setLong(5, oVChipkaart.getKaartNummer());
			stmt.setString(1, oVChipkaart.getGeldigTot());
			stmt.setInt(2, oVChipkaart.getKlasse());
			stmt.setDouble(3, oVChipkaart.getSaldo());
			stmt.setLong(4, oVChipkaart.getReizigerID());
			stmt.execute();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return oVChipkaart;
	}
	
	public OVChipkaart insertOVChipkaart(OVChipkaart oVChipkaart) {
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("INSERT INTO ov_chipkaart VALUES (?,?,?,?,?)");
			stmt.setLong(1, oVChipkaart.getKaartNummer());
			stmt.setString(2, oVChipkaart.getGeldigTot());
			stmt.setInt(3, oVChipkaart.getKlasse());
			stmt.setDouble(4, oVChipkaart.getSaldo());
			stmt.setLong(5, oVChipkaart.getReizigerID());
			stmt.execute();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return oVChipkaart;
	}

	public OVChipkaart deleteOVChipkaart(long id) {
		OVChipkaart oVChipkaart = new OVChipkaart();
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("DELETE FROM ov_chipkaart WHERE kaart_nummer = ?");
			stmt.setLong(1, id);
			stmt.execute();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		oVChipkaart.setKaartNummer(id);
		return oVChipkaart;
	}

	public OVChipkaart selectOVChipkaartWithReizigerInfo(long id) {
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT r.reiziger_id, r.achternaam, ov.kaart_nummer\r\n" + "FROM reiziger r, ov_chipkaart ov\r\n"
							+ "WHERE r.reiziger_id = ov.reiziger_id AND r.reiziger_id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				long reizigerID = rs.getLong("reiziger_id");
				String achternaam = rs.getString("achternaam");
				long kaartNummer = rs.getLong("kaart_nummer");
				OVChipkaart oVChipkaart = new OVChipkaart();
				Reiziger reiziger = new Reiziger();
				oVChipkaart.setReizigerID(reizigerID);
				reiziger.setAchternaam(achternaam);
				oVChipkaart.setReiziger(reiziger);
				oVChipkaart.setKaartNummer(kaartNummer);
				return oVChipkaart;
			}
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}
}