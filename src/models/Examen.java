import javax.persistence.*;
import java.util.List;

@Entity
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int matiereID;
    private int date;
    private int duree;

    @OneToMany(mappedBy = "examen")
    private List<Question> questions;

    public Examen() {
    }

    public Examen(int id, int matiereID, int date, int duree, List<Question> questions) {
        this.id = id;
        this.matiereID = matiereID;
        this.date = date;
        this.duree = duree;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatiereID() {
        return matiereID;
    }

    public void setMatiereID(int matiereID) {
        this.matiereID = matiereID;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    
}
