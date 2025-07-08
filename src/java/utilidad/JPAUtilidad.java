package utilidad;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtilidad {
    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("registroPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}


