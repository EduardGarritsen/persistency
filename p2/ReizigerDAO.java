package p2;

import java.sql.SQLException;

public interface ReizigerDAO {
	
	public Reiziger findReizigerByReizigerID(int ReizigerID) throws SQLException;
	
	public Reiziger findReizigerByReizigerIDWithOVChipkaart(int ReizigerID) throws SQLException;
}
