package Runner;

import com.frozen.redbuss.entity.TicketCancelEntity;
import javax.persistence.*;


public class CreatTicketCancle {
    public static void main(String[] args) {
        TicketCancelEntity ticketCancelEntity = new TicketCancelEntity();
        ticketCancelEntity.setUserId(1);
        ticketCancelEntity.setSeatNo(14);
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(ticketCancelEntity);
            et.commit();
            System.out.println("Data saved successfully: " + ticketCancelEntity);
        } catch (PersistenceException e) {
            et.rollback();
            e.getMessage();
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
