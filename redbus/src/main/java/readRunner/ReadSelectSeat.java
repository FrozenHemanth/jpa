package readRunner;

import com.frozen.redbuss.entity.SelectSeatEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class ReadSelectSeat {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;

        try{
            emf= Persistence.createEntityManagerFactory("Frozen");
            em=emf.createEntityManager();
            SelectSeatEntity selectSeatEntity = em.find(SelectSeatEntity.class, 3);
            System.out.println("Retrieved entity: " + selectSeatEntity);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        finally {
            if(emf!=null){
                emf.close();
            }
            if(em!=null){
                em.close();
            }
        }

    }
}
