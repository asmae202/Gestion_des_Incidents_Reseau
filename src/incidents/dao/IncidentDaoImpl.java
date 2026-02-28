/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.dao;

import incidents.entites.Incident;
import incidents.entites.Equipement;
import incidents.entites.Technicien;
import incidents.connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncidentDaoImpl implements IDao<Incident> {

    private Connection connection = Connexion.getConnexion();

    // ========================= CREATE =========================
    @Override
    public boolean create(Incident i) {
        String sql = "INSERT INTO incident (dateOuverture, dateCloture, priorite, statut, idEquipement, idTechnicien) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setDate(1, new java.sql.Date(i.getDateOuverture().getTime()));

            if (i.getDateCloture() != null) {
                ps.setDate(2, new java.sql.Date(i.getDateCloture().getTime()));
            } else {
                ps.setNull(2, Types.DATE);
            }

            ps.setString(3, i.getPriorite());
            ps.setString(4, i.getStatut());

            // 🔥 ICI ON PREND L’ID DE L’OBJET
            ps.setInt(5, i.getEquipement().getIdEquipement());
            ps.setInt(6, i.getTechnicien().getIdTechnicien());

            ps.executeUpdate();
            ps.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Erreur CREATE Incident : " + e.getMessage());
        }
        return false;
    }

    // ========================= UPDATE =========================
    @Override
    public boolean update(Incident i) {
        String sql = "UPDATE incident SET dateOuverture=?, dateCloture=?, priorite=?, statut=?, idEquipement=?, idTechnicien=? WHERE idIncident=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setDate(1, new java.sql.Date(i.getDateOuverture().getTime()));

            if (i.getDateCloture() != null) {
                ps.setDate(2, new java.sql.Date(i.getDateCloture().getTime()));
            } else {
                ps.setNull(2, Types.DATE);
            }

            ps.setString(3, i.getPriorite());
            ps.setString(4, i.getStatut());

            ps.setInt(5, i.getEquipement().getIdEquipement());
            ps.setInt(6, i.getTechnicien().getIdTechnicien());

            ps.setInt(7, i.getIdIncident());

            ps.executeUpdate();
            ps.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Erreur UPDATE Incident : " + e.getMessage());
        }
        return false;
    }

    // ========================= DELETE =========================
    @Override
    public boolean delete(Incident i) {
        String sql = "DELETE FROM incident WHERE idIncident=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, i.getIdIncident());
            ps.executeUpdate();
            ps.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Erreur DELETE Incident : " + e.getMessage());
        }
        return false;
    }

    // ========================= FIND BY ID =========================
    @Override
    public Incident findById(int id) {
        String sql = "SELECT * FROM incident WHERE idIncident=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id); // ⚠️ corrigé (pas 2 !)

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Equipement e = new Equipement();
                e.setIdEquipement(rs.getInt("idEquipement"));

                Technicien t = new Technicien();
                t.setIdTechnicien(rs.getInt("idTechnicien"));

                return new Incident(
                        rs.getInt("idIncident"),
                        rs.getDate("dateOuverture"),
                        rs.getDate("dateCloture"),
                        rs.getString("priorite"),
                        rs.getString("statut"),
                        e,
                        t
                );
            }

            ps.close();

        } catch (SQLException e) {
            System.out.println("Erreur FIND BY ID Incident : " + e.getMessage());
        }
        return null;
    }

    // ========================= FIND ALL =========================
    @Override
    public List<Incident> findAll() {

        List<Incident> liste = new ArrayList<>();
        String sql = "SELECT * FROM incident";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Equipement e = new Equipement();
                e.setIdEquipement(rs.getInt("idEquipement"));

                Technicien t = new Technicien();
                t.setIdTechnicien(rs.getInt("idTechnicien"));

                Incident i = new Incident(
                        rs.getInt("idIncident"),
                        rs.getDate("dateOuverture"),
                        rs.getDate("dateCloture"),
                        rs.getString("priorite"),
                        rs.getString("statut"),
                        e,
                        t
                );

                liste.add(i);
            }

            st.close();

        } catch (SQLException e) {
            System.out.println("Erreur FIND ALL Incident : " + e.getMessage());
        }

        return liste;
    }
    // ========================= FIND BY PRIORITE =========================
public List<Incident> findByPriorite(String priorite) {
    List<Incident> liste = new ArrayList<>();
    String sql = "SELECT * FROM incident WHERE priorite = ?";

    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, priorite);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Equipement e = new Equipement();
            e.setIdEquipement(rs.getInt("idEquipement"));

            Technicien t = new Technicien();
            t.setIdTechnicien(rs.getInt("idTechnicien"));

            Incident i = new Incident(
                    rs.getInt("idIncident"),
                    rs.getDate("dateOuverture"),
                    rs.getDate("dateCloture"),
                    rs.getString("priorite"),
                    rs.getString("statut"),
                    e,
                    t
            );

            liste.add(i);
        }

        ps.close();

    } catch (SQLException e) {
        System.out.println("Erreur FIND BY PRIORITE Incident : " + e.getMessage());
    }

    return liste;
}
// ========================= FIND BY STATUT =========================
public List<Incident> findByStatut(String statut) {
    List<Incident> liste = new ArrayList<>();
    String sql = "SELECT * FROM incident WHERE statut = ?";
    
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, statut);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Equipement e = new Equipement();
            e.setIdEquipement(rs.getInt("idEquipement"));
            
            Technicien t = new Technicien();
            t.setIdTechnicien(rs.getInt("idTechnicien"));
            
            Incident i = new Incident(
                    rs.getInt("idIncident"),
                    rs.getDate("dateOuverture"),
                    rs.getDate("dateCloture"),
                    rs.getString("priorite"),
                    rs.getString("statut"),
                    e,
                    t
            );
            
            liste.add(i);
        }
        
        ps.close();
        
    } catch (SQLException ex) {
        System.out.println("Erreur FIND BY STATUT Incident : " + ex.getMessage());
    }
    
    return liste;
}
// ========================= FIND ALL STATUTS =========================
public List<String> findAllStatuts() {
    List<String> statuts = new ArrayList<>();
    String sql = "SELECT DISTINCT statut FROM incident";

    try {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            statuts.add(rs.getString("statut"));
        }

        st.close();
    } catch (SQLException e) {
        System.out.println("Erreur FIND ALL STATUTS : " + e.getMessage());
    }

    return statuts;
}
public List<Incident> findByPeriode(Date dateDebut, Date dateFin) {
    List<Incident> liste = new ArrayList<>();
    String sql = "SELECT * FROM incident WHERE dateOuverture BETWEEN ? AND ?";

    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1, new java.sql.Date(dateDebut.getTime()));
        ps.setDate(2, new java.sql.Date(dateFin.getTime()));

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Equipement e = new Equipement();
            e.setIdEquipement(rs.getInt("idEquipement"));

            Technicien t = new Technicien();
            t.setIdTechnicien(rs.getInt("idTechnicien"));

            Incident i = new Incident(
                    rs.getInt("idIncident"),
                    rs.getDate("dateOuverture"),
                    rs.getDate("dateCloture"),
                    rs.getString("priorite"),
                    rs.getString("statut"),
                    e,
                    t
            );

            liste.add(i);
        }

        ps.close();
    } catch (SQLException e) {
        System.out.println("Erreur FIND BY PERIODE : " + e.getMessage());
    }

    return liste;
}

    public List<Incident> findByPeriode(java.util.Date dateDebut, java.util.Date dateFin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}