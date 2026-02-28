/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.test;

import incidents.dao.EquipementDaoImpl;
import incidents.entites.Equipement;
import java.util.List;
/**
 *
 * @author HP
 */
public class TestEquipement {
    
    public static void main(String[] args) {

        EquipementDaoImpl dao = new EquipementDaoImpl();

        Equipement e = new Equipement("Switch_Test", "Switch", "192.168.1.40", "Salle A");
        dao.create(e);

        System.out.println(dao.findAll());
    }
}
