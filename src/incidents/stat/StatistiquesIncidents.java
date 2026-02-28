/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.stat;





import incidents.service.IncidentService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.ResultSet;

public class StatistiquesIncidents {

    public static void afficherDiagramme() {

        try {

            IncidentService service = new IncidentService();
            ResultSet rs = service.countByMonth();

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            while (rs.next()) {
                dataset.setValue(
                        rs.getInt("total"),
                        "Incidents",
                        "Mois " + rs.getInt("mois")
                );
            }

            JFreeChart chart = ChartFactory.createBarChart(
                    "Nombre d'incidents par mois",
                    "Mois",
                    "Nombre d'incidents",
                    dataset
            );

            ChartFrame frame = new ChartFrame("Statistiques", chart);
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}