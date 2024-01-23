package repositories;

import models.Enseignant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public boolean login(String email, String password) {
        String hql = "FROM Enseignant WHERE email = :email AND motDepasse = :mdp";
        Enseignant ens = (Enseignant) s.createQuery(hql)
                .setParameter("email", email)
                .setParameter( "mdp", password)
                .uniqueResult();
        if(ens != null){
            return true;
        }else
            return false;
    }
    
}
