package com.frozen.gasbooking.system.daoimpl;

import com.frozen.gasbooking.system.dao.GasBookingDao;
import com.frozen.gasbooking.system.entity.GasBookingEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class GasBookingDaoImpl implements GasBookingDao {
    @Override
    public Boolean save(GasBookingEntity gasBookingEntity) {
        System.out.println("GasBookingDaoImpl.save() called");
        System.out.println("GasBookingDaoImpl.save() called with gasBookingEntity: " + gasBookingEntity);
        Boolean result = false;
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try{
            emf = Persistence.createEntityManagerFactory("Frozen");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
        em.persist(gasBookingEntity);
        et.commit();
        result = true;

        } catch (Exception e) {
            e.printStackTrace();
            result =  false;
            if(emf != null){
                emf.close();
            }
            return result;
        }
        return null;
    }

    @Override
    public Boolean saveall(List<GasBookingEntity> gasBookingEntities) {

        System.out.println("GasBookingDaoImpl.saveall() called");
        System.out.println("GasBookingDaoImpl.saveall() called with gasBookingEntities: " + gasBookingEntities);
        Boolean result = false;
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try {
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            for (GasBookingEntity entity : gasBookingEntities) {
                em.persist(entity);
            }
            et.commit();
            result = true;
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

        @Override
        public GasBookingEntity getBookingById (String bookingId){
            System.out.println("GasBookingDaoImpl.getBookingById() called");
            System.out.println("GasBookingDaoImpl.getBookingById() called with bookingId: " + bookingId);
            EntityManagerFactory emf = null;
            EntityManager em = null;
            GasBookingEntity gasBookingEntity = null;
            try {
                emf = Persistence.createEntityManagerFactory("Frozen");
                em = emf.createEntityManager();
                gasBookingEntity = em.find(GasBookingEntity.class, bookingId);

            } catch (Exception e) {
                e.printStackTrace();
            return null;
        }
            finally {
                em.close();
                emf.close();

            }
            return gasBookingEntity;
    }

    @Override
    public List<GasBookingEntity> getAllBookings() {
        System.out.println("GasBookingDaoImpl.getAllBookings() called");
      List<GasBookingEntity> gasBookingEntities = Collections.emptyList();
      EntityManagerFactory emf = null;
      EntityManager em = null;

      try {
          emf = Persistence.createEntityManagerFactory("Frozen");
          em = emf.createEntityManager();

          Query query = em.createNamedQuery("getAllBookings");
          gasBookingEntities = query.getResultList();

      } catch (Exception e) {
        e.printStackTrace();
          return List.of();
      }
        return gasBookingEntities;
    }
}



