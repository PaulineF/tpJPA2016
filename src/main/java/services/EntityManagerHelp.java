package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelp {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
    private static final ThreadLocal<EntityManager> tl = new ThreadLocal<EntityManager>();

    public static EntityManager getManager() {
        EntityManager em = tl.get();

        if (em == null) {
            em = emf.createEntityManager();
            tl.set(em);
        }
       if (!em.isOpen())
       {
           em = emf.createEntityManager();
           tl.set(em);
       }
        return em;
    }
    

    public static void closeEntityManager() {
        EntityManager em = tl.get();
        if (em != null) {
            em.close();
            tl.set(null);
        }
    }
    public static void closeEntityManagerFactory() {
        emf.close();
    }

    public static void beginTransaction() {
    	getManager().getTransaction().begin();
    }

    public static void rollback() {
    	getManager().getTransaction().rollback();
    }

    public static void commit() {
    	getManager().getTransaction().commit();
    } 
	

}
