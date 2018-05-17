package p2;

import java.util.Date;

public class OVChipkaart {
	
	private int kaartNummer;
	private Date geldigTot;
	private int klasse;
	private int saldo;
	private Reiziger reizigerID;
	
	public OVChipkaart(int nr, Date tot, int kls, int sal, Reiziger ID) {
		kaartNummer = nr;
		geldigTot = tot;
		klasse = kls;
		saldo = sal;
		reizigerID = ID;
	}

	public int getKaartNummer() {
		return kaartNummer;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public Date getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(Date geldigTot) {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public Reiziger getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(Reiziger reizigerID) {
		this.reizigerID = reizigerID;
	}
	
	public String toString() {
		return String.valueOf(kaartNummer) + " - " + reizigerID.getReizigerID();
	}
	
	
}
