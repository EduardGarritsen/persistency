package persistence;

import java.util.ArrayList;
import domain.Reiziger;

public interface ReizigerDAO {
	public ArrayList<Reiziger> findAll();
	public ArrayList<Reiziger> findByGBdatum(String GBdatum);
	public Reiziger save(Reiziger reiziger);
	public Reiziger update(Reiziger reiziger);
	public boolean delete(Reiziger reiziger);
}