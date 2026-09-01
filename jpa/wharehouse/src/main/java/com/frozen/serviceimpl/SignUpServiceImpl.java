package com.frozen.serviceimpl;

import com.frozen.dao.SignUpDao;
import com.frozen.daoimpl.SignUpDaoImpl;
import com.frozen.dto.SignUpdto;
import com.frozen.entity.SignUpEntity;
import com.frozen.service.SignUpService;

import java.util.List;
import java.util.stream.Collectors;

public class SignUpServiceImpl implements SignUpService {

    SignUpDao signUpDao = new SignUpDaoImpl();

    @Override
    public String saveAndValidate(SignUpdto signUpdto) {
        String isSaved = null;

if(signUpdto != null) {
    SignUpEntity signUpEntity = new SignUpEntity();
    signUpEntity.setName(signUpdto.getName());
    signUpEntity.setEmail(signUpdto.getEmail());
    signUpEntity.setPassword(signUpdto.getPassword());
    Boolean saved = signUpDao.save(signUpEntity);


    if (saved) {
        isSaved = "Data Saved";
    } else {
        isSaved = "Data is Empty";
    }

    return isSaved;
}

        return isSaved;
    }

    @Override
    public String saveAndValidateAll(List<SignUpdto> sign) {
        String isSaved = null;

        if (sign != null) {
            List<SignUpEntity> listOfSignInEntity = sign.stream()
                    .map(signUpdto -> new SignUpEntity(signUpdto.getName(), signUpdto.getEmail(), signUpdto.getPassword()))
                    .collect(Collectors.toList());

            Boolean state = signUpDao.saveAll(listOfSignInEntity);

            if(state){
                isSaved = "The Data is saved";
            }else{
                isSaved = "The Data is not saved";
            }
        }else {
            System.out.println("The data is empty");
        }

        return isSaved;
        }

    @Override
    public SignUpdto findSignUpEntity(Integer id) {
        System.out.println("Finding the Entity by id:"+id);
        SignUpEntity entity = signUpDao.getsignUpEntity(id);
        SignUpdto dto = null;
        if(entity != null){
            dto = new SignUpdto(entity.getName(),entity.getEmail(),entity.getPassword());
            return dto;
        }else{
            System.out.println("The data is empty");
            dto=null;
        }


        return dto;
    }

    @Override
    public SignUpdto findSignUpEntityByName(String name) {
        System.out.println("Finding the Entity by name:"+name);
        SignUpEntity entity = signUpDao.findSignUpEntityByName(name);
        SignUpdto dto = null;
        if(entity != null){
            dto = new SignUpdto(entity.getName(),entity.getEmail(),entity.getPassword());
            return dto;
        }else{
            System.out.println("The data is empty");
            dto=null;
        }


        return dto;
    }

}



