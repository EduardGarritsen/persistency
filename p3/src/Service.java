import domain.OVChipkaart_Product;
import persistence.OVChipkaart_ProductDAO;
import persistence.OVChipkaart_ProductDAOImpl;
import persistence.ProductDAO;
import persistence.ProductDAOImpl;

public class Service {

	public static void main(String[] args) {
		ProductDAO pDAO = new ProductDAOImpl();
		OVChipkaart_ProductDAO ov_pDAO = new OVChipkaart_ProductDAOImpl();
		
		// Select statement vanuit tabel product met het id van 1111111111
		System.out.println("Product rij met id 1111111111");
		System.out.println("Productnaam: " + pDAO.findById(1111111111).getProductNaam());
		System.out.println("Productbeschrijving: " + pDAO.findById(1111111111).getBeschrijving());
		System.out.println("Productprijs: " + pDAO.findById(1111111111).getPrijs());

		// Select statement vanuit tabel ov_chipkaart_product met id van 1111111111
		System.out.println("\nOVChipkaart_Product rij zoeken met id 1111111111");
		System.out.println("Kaartnummer: " + ov_pDAO.findById(1111111111).getoVChipkaart().getKaartNummer());
		System.out.println("Productnummer: " + ov_pDAO.findById(1111111111).getProduct().getProductNummer());
		System.out.println("Reisproduct status: " + ov_pDAO.findById(1111111111).getReisproductStatus());
		System.out.println("Laatste update: " + ov_pDAO.findById(1111111111).getLastUpdate());

		// Select statement vanuit de tabellen ov_chipkaart_product en ov_chipkaart met het id van 1111111111
		System.out.println("\nOVChipkaart_Product rij zoeken uit tabel ov_chipkaart_product en ov_chipkaart met id 1111111111");
		System.out.println("Kaartnummer: " + ov_pDAO.findByIdInOVChipkaart(1111111111).getOvproductID());
		System.out.println("Reisproduct status: " + ov_pDAO.findByIdInOVChipkaart(1111111111).getReisproductStatus());
		System.out
				.println("Kaartnummer: " + ov_pDAO.findByIdInOVChipkaart(1111111111).getoVChipkaart().getKaartNummer());
		System.out.println("saldo: " + ov_pDAO.findByIdInOVChipkaart(1111111111).getoVChipkaart().getSaldo());

		// Select statement vanuit tabellen ov_chipkaart_product en ov_chipkaart en product met het id van 1111111111
		System.out.println("\nOVChipkaart_Product rijen zoeken uit tabel ov_chipkaart_product en ov_chipkaart en product met id 1111111111");
		for (OVChipkaart_Product ov_p : ov_pDAO.findByIdInBothTables(1111111111)) {
			System.out.println("ov_productID: " + ov_p.getOvproductID());
			System.out.println("Reisproduct status: " + ov_p.getReisproductStatus());
			System.out.println("Kaartnummer: " + ov_p.getoVChipkaart().getKaartNummer());
			System.out.println("saldo: " + ov_p.getoVChipkaart().getSaldo());
			System.out.println("productNaam: " + ov_p.getProduct().getProductNaam() + "\n");
		}
	}
}