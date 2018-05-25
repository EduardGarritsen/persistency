package persistence;

import java.util.ArrayList;
import domain.OVChipkaart_Product;

public interface OVChipkaart_ProductDAO {

	public OVChipkaart_Product findById(long id);
	public OVChipkaart_Product findByIdInOVChipkaart(long id);
	public ArrayList<OVChipkaart_Product> findByIdInBothTables(long id);
}
