/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.test;



import incidents.dao.IncidentDaoImpl;
import incidents.entites.Incident;
import java.util.List;

public class Testparpriorite {

    public static void main(String[] args) {

        IncidentDaoImpl dao = new IncidentDaoImpl();

        System.out.println("=========== PRIORITE : HAUTE ===========");
        testerPriorite(dao, "Haute");

        System.out.println("\n=========== PRIORITE : MOYENNE ===========");
        testerPriorite(dao, "Moyenne");

        System.out.println("\n=========== PRIORITE : BASSE ===========");
        testerPriorite(dao, "Basse");
    }

    private static void testerPriorite(IncidentDaoImpl dao, String priorite) {

        List<Incident> liste = dao.findByPriorite(priorite);

        if (liste.isEmpty()) {
            System.out.println("Aucun incident trouvé pour la priorité : " + priorite);
        } else {
            for (Incident i : liste) {

                System.out.println("ID : " + i.getIdIncident());
                System.out.println("Date ouverture : " + i.getDateOuverture());

                if (i.getDateCloture() != null) {
                    System.out.println("Date cloture : " + i.getDateCloture());
                } else {
                    System.out.println("Date cloture : Non cloturé");
                }

                System.out.println("Priorité : " + i.getPriorite());
                System.out.println("Statut : " + i.getStatut());
                System.out.println("-------------------------------------");
            }
        }
    }
}
