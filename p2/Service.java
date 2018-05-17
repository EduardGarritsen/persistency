package p2;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Service {

    public static void main(String[] args){

        ReizigerDAO reizigerDAO = new ReizigerDAOImpl();
        
        try {
        	Reiziger r1 = reizigerDAO.findReizigerByReizigerID(2);
        	Reiziger r2 = reizigerDAO.findReizigerByReizigerID(1);
        	Reiziger r3 = reizigerDAO.findReizigerByReizigerID(3);
        	System.out.println(r1);
        	System.out.println(r2);
        	System.out.println(r3);
        } catch (SQLException ex) {
        	Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
