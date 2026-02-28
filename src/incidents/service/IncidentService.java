/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.service;

import incidents.connexion.Connexion;
import incidents.dao.IDao;
import incidents.entites.Incident;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncidentService implements IDao<Incident> {

    EquipementService es = new EquipementService();
    TechnicienService ts = new TechnicienService();

    @Override
    public boolean create(Incident i) {
        try {
            String req = "INSERT INTO incident VALUES (NULL, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);

            ps.setInt(1, i.getEquipement().getIdEquipement());
            ps.setInt(2, i.getTechnicien().getIdTechnicien());

            // ✅ Conversion obligatoire
            ps.setDate(3, new java.sql.Date(i.getDateOuverture().getTime()));
            ps.setDate(4, new java.sql.Date(i.getDateCloture().getTime()));

            ps.setString(5, i.getPriorite());
            ps.setString(6, i.getStatut());

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Incident i) {
        try {
            String req = "DELETE FROM incident WHERE idIncident = ?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);
            ps.setInt(1, i.getIdIncident());
            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Incident i) {
        try {
            String req = "UPDATE incident SET idEquipement=?, idTechnicien=?, dateOuverture=?, dateCloture=?, priorite=?, statut=? WHERE idIncident=?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);

            ps.setInt(1, i.getEquipement().getIdEquipement());
            ps.setInt(2, i.getTechnicien().getIdTechnicien());
            ps.setDate(3, new java.sql.Date(i.getDateOuverture().getTime()));
            ps.setDate(4, new java.sql.Date(i.getDateCloture().getTime()));
            ps.setString(5, i.getPriorite());
            ps.setString(6, i.getStatut());
            ps.setInt(7, i.getIdIncident());

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Incident> findAll() {

        List<Incident> list = new ArrayList<>();

        try {
            String req = "SELECT * FROM incident";
            Statement st = Connexion.getConnexion().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                list.add(new Incident(
                        rs.getInt("idIncident"),
                        rs.getDate("dateOuverture"),
                        rs.getDate("dateCloture"),
                        rs.getString("priorite"),
                        rs.getString("statut"),
                        es.findById(rs.getInt("idEquipement")),
                        ts.findById(rs.getInt("idTechnicien"))
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Incident findById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // ✅ ✅ METHODE AJOUTÉE POUR RECHERCHE PAR PERIODE
    public List<Incident> findByPeriode(java.util.Date dateDebut, java.util.Date dateFin) {

        List<Incident> list = new ArrayList<>();

        try {

            String req = "SELECT * FROM incident WHERE dateOuverture >= ? AND dateCloture <= ?";
            PreparedStatement ps = Connexion.getConnexion().prepareStatement(req);

            // ✅ Conversion obligatoire java.util.Date → java.sql.Date
            ps.setDate(1, new java.sql.Date(dateDebut.getTime()));
            ps.setDate(2, new java.sql.Date(dateFin.getTime()));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Incident(
                        rs.getInt("idIncident"),
                        rs.getDate("dateOuverture"),
                        rs.getDate("dateCloture"),
                        rs.getString("priorite"),
                        rs.getString("statut"),
                        es.findById(rs.getInt("idEquipement")),
                        ts.findById(rs.getInt("idTechnicien"))
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public ResultSet countByMonth() {
    try {
        String sql = "SELECT MONTH(dateOuverture) as mois, COUNT(*) as total " +
                     "FROM incident GROUP BY MONTH(dateOuverture)";
        PreparedStatement ps = Connexion.getConnexion().prepareStatement(sql);
        return ps.executeQuery();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
    public ResultSet countByTypeEquipement() {
    try {
        String sql = "SELECT e.type, COUNT(*) as total " +
                     "FROM incident i JOIN equipement e " +
                     "ON i.idEquipement = e.idEquipement " +
                     "GROUP BY e.type";
        PreparedStatement ps = Connexion.getConnexion().prepareStatement(sql);
        return ps.executeQuery();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
}