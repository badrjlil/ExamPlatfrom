
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Configuration c = new Configuration();
        c.configure("hibernate.cfg.xml");
        SessionFactory usineSession = c.buildSessionFactory();
        Session s = usineSession.openSession();
    }
}
