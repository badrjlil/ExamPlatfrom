package models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String prenom;
    private String nom;
    private String email;
    private String motDePasse;

    @OneToMany(mappedBy = "enseignant")
    private List<Matiere> matieres;

    public Enseignant() {
    }

    public Enseignant(int id, String prenom, String nom, String email, String motDePasse, List<Matiere> matieres) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.matieres = matieres;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    
}
