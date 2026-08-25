package updateRunner;

import com.frozen.redbuss.entity.SighnUpEntity;
import com.frozen.redbuss.entity.TicketCancelEntity;

import javax.persistence.*;

public class UpdateTicketCancle {
    public static void main(String[] args) {

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try{
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            TicketCancelEntity ticketCancelEntity = em.find(TicketCancelEntity.class, 1);
            System.out.println("before updating :"+ticketCancelEntity);
            if(ticketCancelEntity!=null){
                ticketCancelEntity.setSeatNo(5);
                TicketCancelEntity updatedTicketcancle = em.merge(ticketCancelEntity);
                System.out.println("Updated entity: " + updatedTicketcancle);
                em.getTransaction().commit();
            }


        } catch (PersistenceException e) {
                ;
        }
    }
}
