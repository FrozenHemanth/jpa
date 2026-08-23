package Runner;

import com.frozen.redbuss.entity.SighnUpEntity;
import javax.persistence.*;

public class CreateSighnUp {
    public static void main(String[] args) {
        SighnUpEntity sighnUpEntity = new SighnUpEntity();
        sighnUpEntity.setName("shilpa");
        sighnUpEntity.setEmail("shilpa@gmail.com");
        sighnUpEntity.setPassword("8888");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(sighnUpEntity);
            et.commit();

            System.out.println("Data saved successfully: " + sighnUpEntity);

        } catch (PersistenceException e) {
            // Check if transaction exists and is active before rolling back

                et.rollback();
                e.getMessage();

            System.out.println("Error occurred while saving data: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}