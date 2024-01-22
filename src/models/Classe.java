import javax.persistence.*;
import java.util.List;

@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String niveau;

    @OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiants;

    @ManyToMany
    @JoinTable(
        name = "classe_matiere",
        joinColumns = @JoinColumn(name = "classe_id"),
        inverseJoinColumns = @JoinColumn(name = "matiere_id")
    )
    private List<Matiere> matieres;

    public Classe() {
    }

    public Classe(int id, String niveau, List<Etudiant> etudiants, List<Matiere> matieres) {
        this.id = id;
        this.niveau = niveau;
        this.etudiants = etudiants;
        this.matieres = matieres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    
}
