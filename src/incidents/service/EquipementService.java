package incidents.service;

import incidents.connexion.Connexion;
import incidents.dao.IDao;
import incidents.entites.Equipement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipementService implements IDao<Equipement> {

    @Override
    public boolean create(Equipement e) {
        try {
            String req = "INSERT INTO equipement VALUES (NULL, ?, ?, ?, ?)";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setString(1, e.getNom());
            ps.setString(2, e.getType());
            ps.setString(3, e.getIp());
            ps.setString(4, e.getLocalisation());

            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Equipement e) {
        try {
            String req = "DELETE FROM equipement WHERE idEquipement = ?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setInt(1, e.getIdEquipement());

            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Equipement e) {
        try {
            String req = "UPDATE equipement SET nom = ?, type = ?, ip = ?, localisation = ? WHERE idEquipement = ?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setString(1, e.getNom());
            ps.setString(2, e.getType());
            ps.setString(3, e.getIp());
            ps.setString(4, e.getLocalisation());
            ps.setInt(5, e.getIdEquipement());

            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Equipement findById(int id) {
        try {
            String req = "SELECT * FROM equipement WHERE idEquipement = ?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
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
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Equipement> findAll() {

        List<Equipement> equipements = new ArrayList<>();

        try {
            String req = "SELECT * FROM equipement";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                equipements.add(new Equipement(
                        rs.getInt("idEquipement"),
                        rs.getString("nom"),
                        rs.getString("type"),
                        rs.getString("ip"),
                        rs.getString("localisation")
                ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return equipements;
    }

    // Méthode supplémentaire utile : chercher par type
    public List<Equipement> findByType(String type) {

        List<Equipement> equipements = new ArrayList<>();

        try {
            String req = "SELECT * FROM equipement WHERE type = ?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                equipements.add(new Equipement(
                        rs.getInt("idEquipement"),
                        rs.getString("nom"),
                        rs.getString("type"),
                        rs.getString("ip"),
                        rs.getString("localisation")
                ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return equipements;
    }
}
