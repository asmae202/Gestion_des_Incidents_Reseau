/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.test;

import incidents.entites.Incident;
import incidents.service.IncidentService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Testparperiode {

    public static void main(String[] args) {

        try {

            IncidentService is = new IncidentService();

            // 📅 Définir la période
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date dateDebut = sdf.parse("2024-01-01");
            Date dateFin   = sdf.parse("2024-12-31");

            System.out.println("========== RECHERCHE PAR PERIODE ==========");
            System.out.println("Du " + sdf.format(dateDebut) + " au " + sdf.format(dateFin));
            System.out.println("===========================================\n");

            // 🔎 Recherche
            List<Incident> list = is.findByPeriode(dateDebut, dateFin);

            // ✅ Vérification si vide
            if (list.isEmpty()) {
                System.out.println("❌ Aucun incident trouvé dans cette période.");
            } else {

                for (Incident i : list) {

                    System.out.println("ID : " + i.getIdIncident());
                    System.out.println("Date ouverture : " + sdf.format(i.getDateOuverture()));
                    System.out.println("Date cloture : " + sdf.format(i.getDateCloture()));
                    System.out.println("Priorité : " + i.getPriorite());
                    System.out.println("Statut : " + i.getStatut());

                    // ✅ Vérification null pour éviter erreur
                    if (i.getEquipement() != null) {
                        System.out.println("Equipement ID : " + i.getEquipement().getIdEquipement());
                        System.out.println("Equipement Nom : " + i.getEquipement().getNom());
                    }

                    if (i.getTechnicien() != null) {
                        System.out.println("Technicien ID : " + i.getTechnicien().getIdTechnicien());
                        System.out.println("Technicien Nom : " + i.getTechnicien().getNom());
                    }

                    System.out.println("--------------------------------------------");
                }

                System.out.println("✅ Nombre total d'incidents trouvés : " + list.size());
            }

        } catch (Exception e) {
            System.out.println("Erreur lors du test : " + e.getMessage());
            e.printStackTrace();
        }
    }
}