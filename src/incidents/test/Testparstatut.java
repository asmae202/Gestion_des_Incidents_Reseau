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



import incidents.dao.IncidentDaoImpl;
import incidents.entites.Incident;
import java.util.List;

public class Testparstatut {

    public static void main(String[] args) {

        IncidentDaoImpl dao = new IncidentDaoImpl();

        // 🔥 Récupérer tous les statuts automatiquement
        List<String> statuts = dao.findAllStatuts();

        for (String statut : statuts) {

            System.out.println("====================================");
            System.out.println("STATUT : " + statut);
            System.out.println("====================================");

            List<Incident> incidents = dao.findByStatut(statut);

            for (Incident i : incidents) {

                System.out.println("ID : " + i.getIdIncident());
                System.out.println("Date ouverture : " + i.getDateOuverture());
                System.out.println("Date cloture : " + i.getDateCloture());
                System.out.println("Priorite : " + i.getPriorite());
                System.out.println("Statut : " + i.getStatut());
                System.out.println("ID Equipement : " + i.getEquipement().getIdEquipement());
                System.out.println("ID Technicien : " + i.getTechnicien().getIdTechnicien());
                System.out.println("-----------------------------------");
            }

            if (incidents.isEmpty()) {
                System.out.println("Aucun incident pour ce statut.");
            }

            System.out.println();
        }
    }
}