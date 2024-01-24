package repositories;

import java.util.List;
import models.Enseignant;
import models.Matiere;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class repoEnseignant implements services.serviceEnseignant{

    Session s;
    public repoEnseignant(){
        Configuration c = new Configuration();
        c.configure("models/hibernate.cfg.xml");
        SessionFactory usineSession = c.buildSessionFactory();
        s = usineSession.openSession();
    }
    
    @Override
    public Enseignant login(String email, String password) {
        String hql = "FROM Enseignant WHERE email = :email AND motDepasse = :mdp";
        Enseignant ens = (Enseignant) s.createQuery(hql)
                .setParameter("email", email)
                .setParameter( "mdp", password)
                .uniqueResult();
        return ens;
    }

    @Override
    public List<Matiere> afficherMatieres(int ensID) {
        String hql = "FROM Matiere WHERE enseignant_id = :id";
        List<Matiere> matieres = s.createQuery(hql)
                .setParameter("id", ensID)
                .list();
        return matieres;
    }

    @Override
    public void ajouterMatiere(Matiere matiere) {
        Transaction t = s.beginTransaction();
        s.save(matiere);
        s.flush();
        t.commit();
    }

    @Override
    public void supprimerMatiere(int idMat) {
        Matiere m = s.load(Matiere.class, idMat);
        Transaction t = s.beginTransaction();
        s.delete(m);
        s.flush();
        t.commit();
    }
    
}
