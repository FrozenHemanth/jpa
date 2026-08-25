package updateRunner;

import com.frozen.redbuss.entity.SighnUpEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateSighnup {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            SighnUpEntity sighnUpEntity = em.find(SighnUpEntity.class, 1);
            System.out.println("before updating :" + sighnUpEntity);
            if (sighnUpEntity != null) {

                sighnUpEntity.setEmail("HemanthKumarSb@gmail.com");
                sighnUpEntity.setPassword("1234");
                SighnUpEntity updatedEntity = em.merge(sighnUpEntity);
                System.out.println("Updated entity: " + updatedEntity);


            }
        } finally {
            if (et != null && et.isActive()) {
                et.commit();
            }
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }}
