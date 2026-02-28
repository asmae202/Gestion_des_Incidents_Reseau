/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.dao;

import incidents.entites.Utilisateur;
import incidents.connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDaoImpl implements IDao<Utilisateur> {

    private Connection connection = Connexion.getConnexion();

    @Override
    public boolean create(Utilisateur u) {
        String sql = "INSERT INTO utilisateur (username, password, role) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getRole());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur CREATE Utilisateur : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Utilisateur u) {
        String sql = "UPDATE utilisateur SET username=?, password=?, role=? WHERE idUtilisateur=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getRole());
            ps.setInt(4, u.getIdUtilisateur());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur UPDATE Utilisateur : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Utilisateur u) {
        String sql = "DELETE FROM utilisateur WHERE idUtilisateur=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, u.getIdUtilisateur());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur DELETE Utilisateur : " + e.getMessage());
        }
        return false;
    }

    @Override
    public Utilisateur findById(int id) {
        String sql = "SELECT * FROM utilisateur WHERE idUtilisateur=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Utilisateur u = new Utilisateur(
                        rs.getInt("idUtilisateur"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
                rs.close();
                ps.close();
                return u;
            }
        } catch (SQLException e) {
            System.out.println("Erreur FIND BY ID Utilisateur : " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> liste = new ArrayList<>();
        String sql = "SELECT * FROM utilisateur";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Utilisateur u = new Utilisateur(
                        rs.getInt("idUtilisateur"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
                liste.add(u);
            }

            rs.close();
            st.close();

        } catch (SQLException e) {
            System.out.println("Erreur FIND ALL Utilisateur : " + e.getMessage());
        }

        return liste;
    }

    public Utilisateur findByUsername(String username) {
        String sql = "SELECT * FROM utilisateur WHERE username=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Utilisateur u = new Utilisateur(
                        rs.getInt("idUtilisateur"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
                rs.close();
                ps.close();
                return u;
            }
        } catch (SQLException e) {
            System.out.println("Erreur FIND BY USERNAME : " + e.getMessage());
        }
        return null;
    }

    public Utilisateur login(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}