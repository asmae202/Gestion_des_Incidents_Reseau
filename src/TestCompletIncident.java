/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import incidents.dao.IncidentDaoImpl;
import incidents.entites.Incident;
import incidents.entites.Equipement;
import incidents.entites.Technicien;
import java.util.Date;

public class TestCompletIncident {

    public static void main(String[] args) {

        IncidentDaoImpl dao = new IncidentDaoImpl();

        System.out.println(" CREATE ");

        // 🔥 Création des objets liés
        Equipement e = new Equipement();
        e.setIdEquipement(1);   // ID existant en base

        Technicien t = new Technicien();
        t.setIdTechnicien(1);   // ID existant en base

        Incident i = new Incident(
                new Date(),
                null,
                "Haute",
                "Ouvert",
                e,     // objet Equipement
                t      // objet Technicien
        );

        dao.create(i);

        // ================================
        System.out.println(" FIND ALL ");
        dao.findAll().forEach(System.out::println);

        // ================================
        System.out.println(" FIND BY ID ");
        Incident found = dao.findById(1);
        System.out.println(found);

        // ================================
        System.out.println(" UPDATE ");
        if (found != null) {
            found.setStatut("Cloturé");
            found.setDateCloture(new Date());
            dao.update(found);
        }

        // ================================
        System.out.println(" AFTER UPDATE ");
        dao.findAll().forEach(System.out::println);

        // ================================
        System.out.println(" DELETE ");
        if (found != null) {
            dao.delete(found);
        }

        // ================================
        System.out.println(" AFTER DELETE ");
        dao.findAll().forEach(System.out::println);
    }
}