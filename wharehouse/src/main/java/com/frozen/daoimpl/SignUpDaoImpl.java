package com.frozen.daoimpl;

import com.frozen.dao.SignUpDao;
import com.frozen.entity.SignUpEntity;

import javax.persistence.*;
import java.util.List;

public class SignUpDaoImpl implements SignUpDao {
    @Override
    public Boolean save(SignUpEntity signUpEntity) {
        System.out.println("The save method is running on SignUpDaoImpl");
        System.out.println("Saving the data SignUpEntity: "+signUpEntity);
        Boolean isSaved = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et =null;

        try {
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(signUpEntity);
            isSaved = true;
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            isSaved = false;
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (em != null) {
                em.close();
            }
        }
        return isSaved;
    }
    @Override
    public Boolean saveAll(List<SignUpEntity> sign) {
        System.out.println("Save the list of Data");

        Boolean isSaved = false;

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et =null;


        try {
            emf = Persistence.createEntityManagerFactory("Frozen");
            em = emf.createEntityManager();
            et = em.getTransaction();

            et.begin();

            for(SignUpEntity entity:sign){
                em.persist(entity);
            }

            isSaved = true;
            et.commit();

        } catch (PersistenceException e) {
            e.getMessage();
            isSaved = false;
        }finally {
            if(emf != null){
                emf.close();
            }

            if(em != null){
                em.close();
            }
        }
        return isSaved;
    }


    @Override
    public SignUpEntity getsignUpEntity(Integer id) {
        System.out.println("geting Entity: Dto by id:"+id);
        SignUpEntity entity = null;
        EntityManagerFactory emf = null;

        try{
            entity = Persistence.createEntityManagerFactory("Frozen").createEntityManager().find(SignUpEntity.class, id=1);
        }catch (PersistenceException e){
            e.printStackTrace();
            entity = null;
        }finally {
            if(emf != null){
                emf.close();
            }
        }
        return entity;
    }
}
