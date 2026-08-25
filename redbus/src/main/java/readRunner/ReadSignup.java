package readRunner;

import com.frozen.redbuss.entity.SighnUpEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class ReadSignup {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            SighnUpEntity sighnUpEntity = em.find(SighnUpEntity.class, 1);
            System.out.println("Retrieved entity: " + sighnUpEntity);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }}
