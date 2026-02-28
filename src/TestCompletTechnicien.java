/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import incidents.dao.TechnicienDaoImpl;
import incidents.entites.Technicien;

public class TestCompletTechnicien {

    public static void main(String[] args) {

        TechnicienDaoImpl dao = new TechnicienDaoImpl();

        System.out.println(" CREATE ");
        Technicien t = new Technicien("Sara", "Switching", "sara@test.com");
        dao.create(t);

        System.out.println(" FIND ALL ");
        dao.findAll().forEach(System.out::println);

        System.out.println(" FIND BY ID ");
        Technicien found = dao.findById(1);
        System.out.println(found);

        System.out.println(" UPDATE ");
        if (found != null) {
            found.setSpecialite("Sécurité");
            dao.update(found);
        }

        System.out.println("===== AFTER UPDATE =====");
        dao.findAll().forEach(System.out::println);

        System.out.println("===== DELETE =====");
        if (found != null) {
            dao.delete(found);
        }

        System.out.println("===== AFTER DELETE =====");
        dao.findAll().forEach(System.out::println);
    }
}