package p2;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OVChipkaartDAO {
	
	public ArrayList<OVChipkaart> findAllOVChipkaartenByReizigerID(Reiziger reizigerID) throws SQLException;
}
