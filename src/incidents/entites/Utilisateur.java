package incidents.entites;

public class Utilisateur {

    private int idUtilisateur;
    private String username;
    private String password;
    private String role;

    public Utilisateur() {
    }

    public Utilisateur(int idUtilisateur, String username, String password, String role) {
        this.idUtilisateur = idUtilisateur;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Utilisateur(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + idUtilisateur +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}