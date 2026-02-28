/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import incidents.connexion.Connexion;
import incidents.entites.Equipement;

/**
 *
 * @author HP
 */
public class EquipementDaoImpl implements IDao<Equipement> {
    
    private Connection connection = Connexion.getConnexion();

    @Override
    public boolean create(Equipement e) {
         String sql = "INSERT INTO equipement (nom, type, ip, localisation) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, e.getNom());
            ps.setString(2, e.getType());
            ps.setString(3, e.getIp());
            ps.setString(4, e.getLocalisation());
            ps.executeUpdate();
            ps.close();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Erreur CREATE : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Equipement e) {
        String sql = "UPDATE equipement SET nom=?, type=?, ip=?, localisation=? WHERE idEquipement=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, e.getNom());
            ps.setString(2, e.getType());
            ps.setString(3, e.getIp());
            ps.setString(4, e.getLocalisation());
            ps.setInt(5, e.getIdEquipement());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur UPDATE : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Equipement e) {
         String sql = "DELETE FROM equipement WHERE idEquipement=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, e.getIdEquipement());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur DELETE : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Equipement findById(int id) {
        String sql = "SELECT * FROM equipement WHERE idEquipement=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return new Equipement(
                        rs.getInt("idEquipement"),
                        rs.getString("nom"),
                        rs.getString("type"),
                        rs.getString("ip"),
                        rs.getString("localisation")
                );
                
            } rs.close();
        } catch (SQLException ex) {
            System.out.println("Erreur FIND BY ID : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Equipement> findAll() {
         List<Equipement> list = new ArrayList<>();
        String sql = "SELECT * FROM equipement";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                list.add(new Equipement(
                        rs.getInt("idEquipement"),
                        rs.getString("nom"),
                        rs.getString("type"),
                        rs.getString("ip"),
                        rs.getString("localisation")
                ));
            } rs.close();
        } catch (SQLException ex) {
            System.out.println("Erreur FIND ALL : " + ex.getMessage());
        }
        return list;
    }
    // AJOUTER CETTE METHODE AVANT LA DERNIERE ACCOLADE }

public List<Equipement> findByLocalisation(String localisation) {

    List<Equipement> list = new ArrayList<>();
    String sql = "SELECT * FROM equipement WHERE localisation LIKE ?";

    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + localisation + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Equipement(
                    rs.getInt("idEquipement"),
                    rs.getString("nom"),
                    rs.getString("type"),
                    rs.getString("ip"),
                    rs.getString("localisation")
            ));
        }
        rs.close();
        ps.close();

    } catch (SQLException ex) {
        System.out.println("Erreur FIND BY LOCALISATION : " + ex.getMessage());
    }

    return list;
}
}

