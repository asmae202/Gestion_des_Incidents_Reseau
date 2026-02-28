/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import incidents.dao.EquipementDaoImpl;
import incidents.entites.Equipement;

public class TestCompletEquipement {

    public static void main(String[] args) {

        EquipementDaoImpl dao = new EquipementDaoImpl();

        System.out.println(" TEST CREATE ");
        Equipement e = new Equipement("Routeur_X", "Routeur", "192.168.0.1", "Salle C");
        dao.create(e);

        System.out.println(" TEST FIND ALL ");
        dao.findAll().forEach(System.out::println);

        System.out.println(" TEST FIND BY ID ");
        Equipement found = dao.findById(1);
        System.out.println(found);

        System.out.println(" TEST UPDATE ");
        if (found != null) {
            found.setNom("Routeur_Modifie");
            dao.update(found);
        }

        System.out.println(" APRES UPDATE ");
        dao.findAll().forEach(System.out::println);

        System.out.println(" TEST DELETE ");
        if (found != null) {
            dao.delete(found);
        }

        System.out.println(" APRES DELETE ");
        dao.findAll().forEach(System.out::println);
    }
}