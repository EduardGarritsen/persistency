package persistence;

import java.util.ArrayList;
import domain.OVChipkaart;

public interface OVChipkaartDAO {
	
	public OVChipkaart findById(long id);
	public ArrayList<OVChipkaart> findByReiziger(long id);
	public OVChipkaart insertOVChipkaart(OVChipkaart oVChipkaart);
	public OVChipkaart updateOVChipkaart(OVChipkaart oVChipkaart);
	public OVChipkaart deleteOVChipkaart(long id);
	public OVChipkaart selectOVChipkaartWithReizigerInfo(long id);
}
