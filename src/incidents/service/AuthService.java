package incidents.service;

import incidents.dao.UtilisateurDaoImpl;
import incidents.entites.Utilisateur;
import incidents.utils.HashUtil;

public class AuthService {

    private UtilisateurDaoImpl dao = new UtilisateurDaoImpl();

    public boolean login(String username, String password) {

        Utilisateur u = dao.findByUsername(username);

        if (u == null) {
            return false;
        }

        String hashed = HashUtil.hashPassword(password);

        return u.getPassword().equals(hashed);
    }
}