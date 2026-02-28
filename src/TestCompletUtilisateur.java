/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import incidents.dao.UtilisateurDaoImpl;
import incidents.entites.Utilisateur;
import incidents.service.AuthService;
import incidents.utils.HashUtil;
import java.util.List;

public class TestCompletUtilisateur {

    public static void main(String[] args) {

        UtilisateurDaoImpl dao = new UtilisateurDaoImpl();
        AuthService auth = new AuthService();

        System.out.println(" TEST CREATE ");

        // Hash du mot de passe
        String hashedPassword = HashUtil.hashPassword("1234");

        Utilisateur user = new Utilisateur("admin_test", hashedPassword, "ADMIN");
        dao.create(user);

        System.out.println("Utilisateur ajouté !");
        

        System.out.println("\n TEST FIND ALL ");

        List<Utilisateur> utilisateurs = dao.findAll();
        utilisateurs.forEach(System.out::println);


        System.out.println("\n TEST FIND BY USERNAME ");

        Utilisateur u = dao.findByUsername("admin_test");
        System.out.println(u);


        System.out.println("\n TEST UPDATE ");

        if (u != null) {
            u.setRole("SUPER_ADMIN");
            dao.update(u);
        }

        dao.findAll().forEach(System.out::println);


        System.out.println("\n TEST LOGIN ");

        boolean loginOK = auth.login("admin_test", "1234");

        if (loginOK) {
            System.out.println("Connexion réussie !");
        } else {
            System.out.println("Login incorrect !");
        }


        System.out.println("\n= TEST DELETE ");

        if (u != null) {
            dao.delete(u);
            System.out.println("Utilisateur supprimé !");
        }

        dao.findAll().forEach(System.out::println);

        System.out.println("\n FIN DES TESTS ");
    }
}