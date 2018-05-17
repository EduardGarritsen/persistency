package p2;

import java.util.ArrayList;
import java.util.Date;

public class Reiziger {
	
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date geboortedatum;
	
	private ArrayList<OVChipkaart> OVChipkaarten = new ArrayList<OVChipkaart>();
	
	public Reiziger(int ID, String vrl, String tvgl, String achtn, Date gbd) {
		reizigerID = ID;
		voorletters = vrl;
		tussenvoegsel = tvgl;
		achternaam = achtn;
		geboortedatum = gbd;
	}

	public int getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(int reizigerID) {
		reizigerID = reizigerID;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public Date getGeboortedatum() {
		return geboortedatum;
	}

	public void setGeboortedatum(Date geboortedatum) {
		this.geboortedatum = geboortedatum;
	}
	
	public void voegToeOVChipkaart(OVChipkaart ov) {
		OVChipkaarten.add(ov);
	}
	
	public boolean verwijderOVChipkaart(OVChipkaart ov) {
		return OVChipkaarten.remove(ov);
	}
	
	public int getAantalOVChipkaarten() {
		return OVChipkaarten.size();
	}
	
	public String toString() {
		return reizigerID + ": " + voorletters + " - " + tussenvoegsel + " - " + 
				achternaam + " - " + geboortedatum;
	}
	
	void setOVChipkaarten(ArrayList<OVChipkaart> OVChipkaart) {
		this.OVChipkaarten = OVChipkaarten;
	}
	
}
