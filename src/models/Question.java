import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texte;
    private int reponsesPossibles;

    @ElementCollection
    private List<String> reponses;

    private int indexReponseCorrecte;

    @ManyToOne
    @JoinColumn(name = "examen_id")
    private Examen examen;

    public Question() {
    }

    public Question(int id, String texte, int reponsesPossibles, List<String> reponses, int indexReponseCorrecte, Examen examen) {
        this.id = id;
        this.texte = texte;
        this.reponsesPossibles = reponsesPossibles;
        this.reponses = reponses;
        this.indexReponseCorrecte = indexReponseCorrecte;
        this.examen = examen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getReponsesPossibles() {
        return reponsesPossibles;
    }

    public void setReponsesPossibles(int reponsesPossibles) {
        this.reponsesPossibles = reponsesPossibles;
    }

    public List<String> getReponses() {
        return reponses;
    }

    public void setReponses(List<String> reponses) {
        this.reponses = reponses;
    }

    public int getIndexReponseCorrecte() {
        return indexReponseCorrecte;
    }

    public void setIndexReponseCorrecte(int indexReponseCorrecte) {
        this.indexReponseCorrecte = indexReponseCorrecte;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    
}
