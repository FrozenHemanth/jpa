package com.frozen.service;

import com.frozen.dto.SignUpdto;
import com.frozen.entity.SignUpEntity;

import java.util.List;

public interface SignUpService {
    public String saveAndValidate(SignUpdto signUpdto);
    public String saveAndValidateAll(List<SignUpdto> signUpdtos );

    public SignUpdto findSignUpEntity(Integer id);

}
