package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Product;

public class ProductDAOImpl extends OracleBaseDAO implements ProductDAO {
	public Product findById(long id) {
		Product p = new Product();
		try (Connection con = super.getConnection()) {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM product WHERE product_nummer = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				long productNummer = rs.getLong("product_nummer");
				String productNaam = rs.getString("product_naam");
				String beschrijving = rs.getString("beschrijving");
				double prijs = rs.getDouble("prijs");
				p.setProductNummer(productNummer);
				p.setProductNaam(productNaam);
				p.setBeschrijving(beschrijving);
				p.setPrijs(prijs);
			}
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return p;
	}
}