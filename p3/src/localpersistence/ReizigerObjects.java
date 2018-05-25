package localpersistence;

import java.text.ParseException;
import java.util.ArrayList;
import domain.Reiziger;

public class ReizigerObjects {
	public ArrayList<Reiziger> getLocalReizigers() throws ParseException {
		ArrayList<Reiziger> reizigerList = new ArrayList<Reiziger>();
		Reiziger reiziger1 = new Reiziger(1, "K", "O", "Kamal", "05-04-1995");
		Reiziger reiziger2 = new Reiziger(2, "R", "B", "Sikkens", "27-06-1997");
		Reiziger reiziger3 = new Reiziger(3, "E", "D", "Garritsen", "27-09-1998");
		reizigerList.add(reiziger1);
		reizigerList.add(reiziger2);
		reizigerList.add(reiziger3);
		return reizigerList;
	}
}
