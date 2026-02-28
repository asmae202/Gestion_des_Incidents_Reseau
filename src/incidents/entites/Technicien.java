/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.entites;

/**
 *
 * @author HP
 */
public class Technicien {
    private int idTechnicien;
    private String nom;
    private String specialite;
    private String email;

    public Technicien() {
    }

    public Technicien(int idTechnicien, String nom, String specialite, String email) {
        this.idTechnicien = idTechnicien;
        this.nom = nom;
        this.specialite = specialite;
        this.email = email;
    }
    
    public Technicien(String nom, String specialite, String email) {
    this.nom = nom;
    this.specialite = specialite;
    this.email = email;
}

    // Getters & Setters
    public int getIdTechnicien() {
        return idTechnicien;
    }

    public void setIdTechnicien(int idTechnicien) {
        this.idTechnicien = idTechnicien;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
@Override
public String toString() {
    return nom;   // ou prenom + " " + nom
}
}

