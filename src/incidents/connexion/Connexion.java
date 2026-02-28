/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package incidents.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    private static String login = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://127.0.0.1:3306/gestion_incidents";

    private static Connection connexion;

    static {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        connexion = DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1:3306/gestion_incidents",
            "root",
            ""
        );

        if (connexion != null) {
            System.out.println("✅ Connexion établie avec succès !");
        } else {
            System.out.println("❌ Connexion NULL !");
        }

    } catch (Exception ex) {
        System.out.println("❌ ERREUR CONNEXION :");
        ex.printStackTrace();
    }
}

    public static Connection getConnexion() {
        return connexion;
    }
}