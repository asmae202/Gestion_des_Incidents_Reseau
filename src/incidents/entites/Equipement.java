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
public class Equipement {
    private int idEquipement;
    private String nom;
    private String type;
    private String ip;
    private String localisation;

    public Equipement() {
    }

    public Equipement(int idEquipement, String nom, String type, String ip, String localisation) {
        this.idEquipement = idEquipement;
        this.nom = nom;
        this.type = type;
        this.ip = ip;
        this.localisation = localisation;
    }
    
    public Equipement(String nom, String type, String ip, String localisation) {
    this.nom = nom;
    this.type = type;
    this.ip = ip;
    this.localisation = localisation;
}

    public int getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(int idEquipement) {
        this.idEquipement = idEquipement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    
@Override
public String toString() {
    return nom; 
}
}


