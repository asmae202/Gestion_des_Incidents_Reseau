/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.test;

import incidents.dao.IncidentDaoImpl;
import incidents.entites.Incident;
import incidents.entites.Equipement;
import incidents.entites.Technicien;
import java.util.Date;

public class TestIncident {

    public static void main(String[] args) {

        IncidentDaoImpl dao = new IncidentDaoImpl();

        // 🔥 On crée les objets Equipement et Technicien
        Equipement e = new Equipement();
        e.setIdEquipement(6);   // id existant en base

        Technicien t = new Technicien();
        t.setIdTechnicien(6);   // id existant en base

        // 🔥 Nouveau constructeur avec objets
        Incident i = new Incident(
                new Date(),      // dateOuverture
                null,            // dateCloture
                "Haute",         // priorite
                "Ouvert",        // statut
                e,               // objet Equipement
                t                // objet Technicien
        );

        dao.create(i);

        System.out.println(dao.findAll());
    }
}