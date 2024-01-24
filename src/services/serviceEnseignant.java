package services;
import java.util.List;
import models.Enseignant;
import models.Matiere;
public interface serviceEnseignant {
    public Enseignant login(String email, String password);
    public List<Matiere> afficherMatieres(int ensID);
    public void ajouterMatiere(Matiere matiere);
    public void supprimerMatiere(int idMat);
}
