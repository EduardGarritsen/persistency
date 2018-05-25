package persistence;

import java.text.ParseException;
import java.util.ArrayList;
import domain.Reiziger;
import localpersistence.ReizigerObjects;

public class ReizigerLocalDAOImpl implements ReizigerDAO {
	
	ReizigerObjects reizigerObject = new ReizigerObjects();
	ArrayList<Reiziger> reizigerList = new ArrayList<Reiziger>();

	public ArrayList<Reiziger> findAll() {
		ArrayList<Reiziger> reizigerList = new ArrayList<Reiziger>();
		try {
			if (this.reizigerList.size() == 0) {
				for (Reiziger reiziger : reizigerObject.getLocalReizigers()) {
					Reiziger r = new Reiziger();
					r.setReizigerID(reiziger.getReizigerID());
					r.setVoorletters(reiziger.getVoorletters());
					r.setTussenvoegsel(reiziger.getTussenvoegsel());
					r.setAchternaam(reiziger.getAchternaam());
					r.setGeboortedatum(reiziger.getGeboortedatum());
					this.reizigerList = reizigerList;
					reizigerList.add(r);
				}
			} else {
				for (Reiziger reiziger : this.reizigerList) {
					Reiziger r = new Reiziger();
					r.setReizigerID(reiziger.getReizigerID());
					r.setVoorletters(reiziger.getVoorletters());
					r.setTussenvoegsel(reiziger.getTussenvoegsel());
					r.setAchternaam(reiziger.getAchternaam());
					r.setGeboortedatum(reiziger.getGeboortedatum());
					reizigerList.add(r);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return reizigerList;
	}

	public ArrayList<Reiziger> findByGBdatum(String GBdatum) {
		ArrayList<Reiziger> reizigerList = new ArrayList<Reiziger>();
		for (Reiziger reiziger : this.reizigerList) {
			if (reiziger.getGeboortedatum().equals(GBdatum)) {
				reizigerList.add(reiziger);
			}
		}
		return reizigerList;
	}

	public Reiziger save(Reiziger reiziger) {
		reizigerList.add(reiziger);
		return reiziger;
	}

	public Reiziger update(Reiziger reiziger) {
		for (int i = 0; i < reizigerList.size(); i++) {
			if (reizigerList.get(i).getReizigerID() == reiziger.getReizigerID()) {
				reizigerList.set(i, reiziger);
				return reiziger;
			}
		}
		return null;
	}

	public boolean delete(Reiziger reiziger) {
		for (int i = 0; i < reizigerList.size(); i++) {
			if (reizigerList.get(i).getReizigerID() == reiziger.getReizigerID()) {
				reizigerList.remove(i);
				return true;
			}
		}
		return false;
	}
}