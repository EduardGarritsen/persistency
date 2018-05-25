package domain;

public class OVChipkaart {

	private long kaartNummer;
	private String geldigTot;
	private int klasse;
	private double saldo;
	private long reizigerID;
	private Reiziger reiziger;

	public OVChipkaart() {
	}

	public OVChipkaart(long kaartNummer, String geldigTot, int klasse, double saldo, long reizigerID) {
		super();
		this.kaartNummer = kaartNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reizigerID = reizigerID;
	}

	public long getKaartNummer() {
		return kaartNummer;
	}

	public void setKaartNummer(long kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public String getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(String geldigTot) {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public long getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(long reizigerID) {
		this.reizigerID = reizigerID;
	}

	public Reiziger getReiziger() {
		return reiziger;
	}

	public void setReiziger(Reiziger reiziger) {
		this.reiziger = reiziger;
	}
}
