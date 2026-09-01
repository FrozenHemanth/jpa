package com.frozen.dao;

import com.frozen.entity.SignUpEntity;

import java.util.List;

public interface SignUpDao {

    Boolean save(SignUpEntity signUpEntity);
    Boolean saveAll (List<SignUpEntity> signUpEntity);

    public SignUpEntity getsignUpEntity(Integer id);

    public SignUpEntity findSignUpEntityByName(String name);

}
