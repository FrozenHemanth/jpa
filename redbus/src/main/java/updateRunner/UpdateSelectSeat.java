package updateRunner;

import com.frozen.redbuss.entity.SelectSeatEntity;
import com.frozen.redbuss.entity.TicketCancelEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateSelectSeat {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try{
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            SelectSeatEntity selectSeatEntity = em.find(SelectSeatEntity.class, 3);
            System.out.println("before updating :"+selectSeatEntity);
            if(selectSeatEntity != null) {
                selectSeatEntity.setUserId(3);
                SelectSeatEntity updatedSelectSeat = em.merge(selectSeatEntity);
                System.out.println("after updating :" + updatedSelectSeat);
                et.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if(et != null) et.rollback();
        }
        finally {
            if(em != null) em.close();
            if(emf != null) emf.close();
        }
    }
}
