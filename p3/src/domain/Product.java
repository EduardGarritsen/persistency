package domain;

public class Product {

	private long productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;

	public Product() {
	}

	public Product(long productNummer, String productNaam, String beschrijving, double prijs) {
		super();
		this.productNummer = productNummer;
		this.productNaam = productNaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
	}

	public long getProductNummer() {
		return productNummer;
	}

	public void setProductNummer(long productNummer) {
		this.productNummer = productNummer;
	}

	public String getProductNaam() {
		return productNaam;
	}

	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
}