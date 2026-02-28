/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import incidents.connexion.Connexion;

public class UserService {

    private Connection con;

    // 🔗 CONSTRUCTEUR PROPRE
   public UserService() {
    con = Connexion.getConnexion();

    if (con == null) {
        System.out.println("❌ CONNEXION EST NULL DANS USERSERVICE");
    } else {
        System.out.println("✅ CONNEXION OK DANS USERSERVICE");
    }
}

    // ✅ INSERTION UTILISATEUR
    public void insert(String email, String password, String code) throws Exception {

        String sql = "INSERT INTO users (email, password, verification_code, verified) VALUES (?, ?, ?, false)";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, email.trim());
        pst.setString(2, password.trim());
        pst.setString(3, code.trim());

        pst.executeUpdate();
    }

    // ✅ VÉRIFIER + ACTIVER
    public boolean verifyAndActivate(String email, String code) throws Exception {

        String sql = "SELECT * FROM users WHERE email=? AND verification_code=?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, email.trim());
        pst.setString(2, code.trim());

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            String update = "UPDATE users SET verified=true WHERE email=?";
            PreparedStatement pst2 = con.prepareStatement(update);
            pst2.setString(1, email.trim());
            pst2.executeUpdate();

            return true;
        }

        return false;
    }

    // ✅ LOGIN
    public boolean login(String email, String password) throws Exception {

        String sql = "SELECT * FROM users WHERE email=? AND password=? AND verified=true";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, email.trim());
        pst.setString(2, password.trim());

        ResultSet rs = pst.executeQuery();

        return rs.next();
    }

    // ✅ UPDATE PASSWORD
    public void updatePassword(String email, String newPassword) throws Exception {

        String sql = "UPDATE users SET password=? WHERE email=?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, newPassword.trim());
        pst.setString(2, email.trim());

        pst.executeUpdate();
    }
}