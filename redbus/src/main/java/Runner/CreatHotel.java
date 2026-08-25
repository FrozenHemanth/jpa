package Runner;

import com.frozen.redbuss.entity.HotelEntity;

import javax.persistence.*;
import java.time.LocalDate;

public class CreatHotel {
    public static void main(String[] args) {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setCityName("Mumbai");
        hotelEntity.setCheckInDate(LocalDate.now());
        hotelEntity.setCheckOutDate(LocalDate.now().plusDays(1));
        hotelEntity.setNoOfGuest(2);

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try{
            emf= Persistence.createEntityManagerFactory("Frozen");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();
            em.persist(hotelEntity);
            et.commit();
            System.out.println("Data saved successfully: " + hotelEntity);


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

