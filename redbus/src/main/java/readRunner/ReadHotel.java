package readRunner;


import com.frozen.redbuss.entity.HotelEntity;

import javax.persistence.*;

public class ReadHotel {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            HotelEntity hotelEntity = em.find(HotelEntity.class, 1);
            System.out.println("Retrieved entity: " + hotelEntity);
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
    }
}
