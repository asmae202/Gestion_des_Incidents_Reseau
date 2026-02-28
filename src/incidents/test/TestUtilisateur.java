/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidents.test;

import incidents.dao.UtilisateurDaoImpl;
import incidents.entites.Utilisateur;
import incidents.utils.HashUtil;

public class TestUtilisateur {

    public static void main(String[] args) {

        UtilisateurDaoImpl dao = new UtilisateurDaoImpl();

        String hashed = HashUtil.hashPassword("1234");

        Utilisateur u = new Utilisateur("admin", hashed, "ADMIN");

        dao.create(u);

        System.out.println(dao.findAll());
    }
}