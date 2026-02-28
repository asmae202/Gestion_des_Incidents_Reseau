/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.service;

import incidents.connexion.Connexion;
import incidents.dao.IDao;
import incidents.entites.Technicien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TechnicienService implements IDao<Technicien> {

    @Override
    public boolean create(Technicien t) {
        try {
            String req = "INSERT INTO technicien VALUES (NULL, ?, ?, ?)";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setString(1, t.getNom());
            ps.setString(2, t.getSpecialite());
            ps.setString(3, t.getEmail());

            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Technicien t) {
        try {
            String req = "DELETE FROM technicien WHERE idTechnicien = ?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setInt(1, t.getIdTechnicien());

            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Technicien t) {
        try {
            String req = "UPDATE technicien SET nom = ?, specialite = ?, email = ? WHERE idTechnicien = ?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setString(1, t.getNom());
            ps.setString(2, t.getSpecialite());
            ps.setString(3, t.getEmail());
            ps.setInt(4, t.getIdTechnicien());

            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Technicien findById(int id) {
        try {
            String req = "SELECT * FROM technicien WHERE idTechnicien = ?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Technicien(
                        rs.getInt("idTechnicien"),
                        rs.getString("nom"),
                        rs.getString("specialite"),
                        rs.getString("email")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Technicien> findAll() {
        List<Technicien> techniciens = new ArrayList<>();

        try {
            String req = "SELECT * FROM technicien";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                techniciens.add(new Technicien(
                        rs.getInt("idTechnicien"),
                        rs.getString("nom"),
                        rs.getString("specialite"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return techniciens;
    }

    // Méthode supplémentaire utile
    public List<Technicien> findBySpecialite(String specialite) {
        List<Technicien> techniciens = new ArrayList<>();

        try {
            String req = "SELECT * FROM technicien WHERE specialite = ?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setString(1, specialite);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                techniciens.add(new Technicien(
                        rs.getInt("idTechnicien"),
                        rs.getString("nom"),
                        rs.getString("specialite"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return techniciens;
    }
}