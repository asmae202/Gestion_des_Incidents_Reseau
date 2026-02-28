/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.dao;

import incidents.entites.Technicien;
import incidents.connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP
 */
public class TechnicienDaoImpl implements IDao<Technicien>{

   private Connection connection = Connexion.getConnexion(); 
    @Override
    public boolean create(Technicien t) {
        String sql = "INSERT INTO technicien (nom, specialite, email) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, t.getNom());
            ps.setString(2, t.getSpecialite());
            ps.setString(3, t.getEmail());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur CREATE Technicien : " + ex.getMessage());
        }
        return false;
    }
    

    @Override
    public boolean update(Technicien e) {
      String sql = "UPDATE technicien SET nom=?, specialite=?, email=? WHERE idTechnicien=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, e.getNom());
            ps.setString(2, e.getSpecialite());
            ps.setString(3, e.getEmail());
            ps.setInt(4, e.getIdTechnicien());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur UPDATE Technicien : " + ex.getMessage());
        }
        return false;  
    }

    @Override
    public boolean delete(Technicien t) {
        
        String sql = "DELETE FROM technicien WHERE idTechnicien=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getIdTechnicien());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur DELETE Technicien : " + e.getMessage());
        }
        return false;
    }

    @Override
    public Technicien findById(int id) {
        String sql = "SELECT * FROM technicien WHERE idTechnicien=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
           

            if (rs.next()) {
                return new Technicien(
                        rs.getInt("idTechnicien"),
                        rs.getString("nom"),
                        rs.getString("specialite"),
                        rs.getString("email")
                );
            } ps.close();
        } catch (SQLException e) {
            System.out.println("Erreur FIND BY ID Technicien : " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Technicien> findAll() {
List<Technicien> liste = new ArrayList<>();
        String sql = "SELECT * FROM technicien";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            

            while (rs.next()) {
                Technicien t = new Technicien(
                        rs.getInt("idTechnicien"),
                        rs.getString("nom"),
                        rs.getString("specialite"),
                        rs.getString("email")
                );
                liste.add(t);
            }
             st.close();
        } catch (SQLException e) {
            System.out.println("Erreur FIND ALL Technicien : " + e.getMessage());
        }

        return liste;
    }
    }
    

