package com.frozen.daoimpl;

import com.frozen.dao.PaymentDao;
import com.frozen.entity.PaymentEntity;

import javax.persistence.*;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {
    @Override

    public Boolean savePayment(PaymentEntity paymentEntity) {
        System.out.println("PaymentDaoImpl.savePayment() called");
        System.out.println("PaymentDaoImpl.savePayment() called with paymentEntity: " + paymentEntity);
      Boolean isSaved = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try{
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(paymentEntity);
            et.commit();
            isSaved = true;

        } catch (PersistenceException e) {
            e.printStackTrace();
            isSaved = false;
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return null;
    }

    @Override
    public Boolean saveAllPayments(List<PaymentEntity> paymentEntities) {
        System.out.println("PaymentDaoImpl.saveAllPayments() called");
        System.out.println("PaymentDaoImpl.saveAllPayments() called with paymentEntities: " +paymentEntities);
        Boolean isSaved = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        try{
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            for(PaymentEntity entity:paymentEntities){
                em.persist(entity);
            }
        }   catch (PersistenceException e) {
            e.printStackTrace();
            isSaved = false;
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return isSaved;
    }


    @Override
    public PaymentEntity getPaymentEntityByReceipt(String receipt) {
        System.out.println("PaymentDaoImpl.getPaymentEntityByReceipt() called");
        EntityManagerFactory emf = null;
        EntityManager em = null;
        PaymentEntity paymentEntity = null;
        try{
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            paymentEntity = em.find(PaymentEntity.class, receipt);
        } catch (Exception e) {
            e.printStackTrace();
            paymentEntity = null;
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return paymentEntity;
    }

    @Override
    public PaymentEntity findPaymentEntitybyCurrency(String currency) {
        System.out.println("PaymentDaoImpl.findPaymentEntitybyCurrency() called");
        System.out.println("PaymentDaoImpl.findPaymentEntitybyCurrency() called with currency: "+ currency);
        EntityManagerFactory emf = null;

        PaymentEntity paymentEntity = null;
        try{
            paymentEntity = Persistence.createEntityManagerFactory("Frozen").createEntityManager().find(PaymentEntity.class,"USD");

        } catch (Exception e) {
            e.printStackTrace();
            paymentEntity = null;
        }


        return paymentEntity;
    }
}



