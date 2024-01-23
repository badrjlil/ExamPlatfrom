package models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String prenom;
    private String nom;
    private String email;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    public Etudiant() {
    }

    public Etudiant(int id, String prenom, String nom, String email, Classe classe) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.classe = classe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    
}
