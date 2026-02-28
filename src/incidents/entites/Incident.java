/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.entites;

import java.util.Date;

public class Incident {

    private int idIncident;
    private Date dateOuverture;
    private Date dateCloture;
    private String priorite;
    private String statut;

    private Equipement equipement;
    private Technicien technicien;

    public Incident() {
    }

    public Incident(int idIncident, Date dateOuverture, Date dateCloture,
                    String priorite, String statut,
                    Equipement equipement, Technicien technicien) {
        this.idIncident = idIncident;
        this.dateOuverture = dateOuverture;
        this.dateCloture = dateCloture;
        this.priorite = priorite;
        this.statut = statut;
        this.equipement = equipement;
        this.technicien = technicien;
    }

    public Incident(Date dateOuverture, Date dateCloture,
                    String priorite, String statut,
                    Equipement equipement, Technicien technicien) {
        this.dateOuverture = dateOuverture;
        this.dateCloture = dateCloture;
        this.priorite = priorite;
        this.statut = statut;
        this.equipement = equipement;
        this.technicien = technicien;
    }

    // GETTERS & SETTERS

    public int getIdIncident() { return idIncident; }
    public void setIdIncident(int idIncident) { this.idIncident = idIncident; }

    public Date getDateOuverture() { return dateOuverture; }
    public void setDateOuverture(Date dateOuverture) { this.dateOuverture = dateOuverture; }

    public Date getDateCloture() { return dateCloture; }
    public void setDateCloture(Date dateCloture) { this.dateCloture = dateCloture; }

    public String getPriorite() { return priorite; }
    public void setPriorite(String priorite) { this.priorite = priorite; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Equipement getEquipement() { return equipement; }
    public void setEquipement(Equipement equipement) { this.equipement = equipement; }

    public Technicien getTechnicien() { return technicien; }
    public void setTechnicien(Technicien technicien) { this.technicien = technicien; }

    @Override
    public String toString() {
        return statut;
    }
}