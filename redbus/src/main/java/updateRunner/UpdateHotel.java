package updateRunner;

import com.frozen.redbuss.entity.HotelEntity;

import javax.persistence.*;
import java.time.LocalDate;

public class UpdateHotel {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try{
            emf= Persistence.createEntityManagerFactory("Frozen");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();

            HotelEntity hotelEntity = em.find(HotelEntity.class, 1);
            System.out.println("Before updating :"+hotelEntity);
            if(hotelEntity!=null) {
                hotelEntity.setCityName("dheli");
                hotelEntity.setCheckInDate(LocalDate.now());
                hotelEntity.setCheckOutDate(LocalDate.now().plusDays(1));
                hotelEntity.setNoOfGuest(2);

                em.merge(hotelEntity);
                et.commit();
                System.out.println("After updating : " + hotelEntity);
            }
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

