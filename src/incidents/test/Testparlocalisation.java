/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.test;

/**
 *
 * @author pc
 */


import incidents.dao.EquipementDaoImpl;
import incidents.entites.Equipement;
import java.util.List;

public class Testparlocalisation {

    public static void main(String[] args) {

        EquipementDaoImpl dao = new EquipementDaoImpl();

        // 🔎 Tester plusieurs cas
        String[] localisations = {"Salle Serveur", "Etage 1", "Accueil", "Salle A"};

        for (String loc : localisations) {

            System.out.println("===== Recherche pour : " + loc + " =====");

            List<Equipement> list = dao.findByLocalisation(loc);

            if (list.isEmpty()) {
                System.out.println("Aucun équipement trouvé !");
            } else {
                for (Equipement e : list) {
                    System.out.println(
                            "ID: " + e.getIdEquipement()
                            + " | Nom: " + e.getNom()
                            + " | Type: " + e.getType()
                            + " | IP: " + e.getIp()
                            + " | Localisation: " + e.getLocalisation()
                    );
                }
            }

            System.out.println("\n");
        }
    }
}
