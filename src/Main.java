
import interfaces.Home;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import models.Classe;
import models.Etudiant;
import models.Enseignant;
import models.Matiere;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        /*Configuration c = new Configuration();
        c.configure("models/hibernate.cfg.xml");
        SessionFactory usineSession = c.buildSessionFactory();
        Session s = usineSession.openSession();
        
        
        
        Transaction t = s.beginTransaction();
        Etudiant e1 = new Etudiant();
        e1.setPrenom("Salim");
        e1.setNom("Taha");
        e1.setEmail("e1@gmail.com");
        e1.setMotDePasse("123456");
        
        Etudiant e2 = new Etudiant();
        e2.setPrenom("Mohamed");
        e2.setPrenom("Ahmed");
        e2.setEmail("e2@gmail.com");
        e2.setMotDePasse("123456");
       
        
        Enseignant en1 = new Enseignant();
        en1.setPrenom("Khalid");
        en1.setNom("Ziraoui");
        en1.setEmail("p1@gmail.com");
        en1.setMotDePasse("123456");
        
        Enseignant en2 = new Enseignant();
        en2.setPrenom("Salwa");
        en2.setNom("Ansary");
        en2.setEmail("p2@gmail.com");
        en2.setMotDePasse("123456");
        
        Matiere m1 = new Matiere();
        m1.setNom("Analyse");
        m1.setEnseignant(en1);
        
        Classe cl = new Classe();
        cl.setNiveau("4GI");
        
        
        e1.setClasse(cl);
        e2.setClasse(cl);
        
        List<Matiere> matieres = new ArrayList<>();
        matieres.add(m1);
        
        cl.setMatieres(matieres);
        
        en1.setMatieres(matieres);
        
        List<Classe> classes = new ArrayList<>();
        classes.add(cl);
        m1.setClasses(classes);
        
        
        s.save(e1);
        s.save(e2);
        s.save(en1);
        s.save(en2);
        s.save(m1);
        s.save(cl);
        s.flush();
        t.commit();
        */
        new Home().setVisible(true);
    }
}
