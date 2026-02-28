/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.test;

/**
 *
 * @author HP
 */

    import incidents.dao.TechnicienDaoImpl;
import incidents.entites.Technicien;

public class TestTechnicien {

    public static void main(String[] args) {

        TechnicienDaoImpl dao = new TechnicienDaoImpl();

        // Création d’un technicien
        Technicien t = new Technicien("Ali", "Réseau", "ali3@test.com");

        dao.create(t);

        // Affichage de tous les techniciens
        System.out.println(dao.findAll());
    }
}

