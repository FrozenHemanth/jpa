package Runner;

import com.frozen.redbuss.entity.SelectSeatEntity;

import javax.persistence.*;

public class CreatSelectSeat {

    public static void main(String[] args) {
        SelectSeatEntity selectSeatEntity = new SelectSeatEntity();
        selectSeatEntity.setUserId(5);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf= Persistence.createEntityManagerFactory("Frozen");
           em=emf.createEntityManager();
           et=em.getTransaction();
           et.begin();
           em.persist(selectSeatEntity);
            et.commit();
            System.out.println("Data saved successfully: " + selectSeatEntity);


        } catch (PersistenceException e) {
            et.rollback();
            System.out.println("Error occurred while saving data: " + e.getMessage());
            e.printStackTrace();

        }
        finally {
            if(em!=null){
                em.close();
            }
            if(emf!=null)
            emf.close();
        }
    }
}
