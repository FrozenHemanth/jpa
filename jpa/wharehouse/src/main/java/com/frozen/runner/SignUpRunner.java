package com.frozen.runner;

import com.frozen.dto.SignUpdto;
import com.frozen.entity.SignUpEntity;
import com.frozen.service.SignUpService;
import com.frozen.serviceimpl.SignUpServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class SignUpRunner {
    public static void main(String[] args) {
        //For single element
      //  SignUpdto signUpdto = new SignUpdto("priya", "kumar@gmail.com", "kumar");
        //SignUpService signUpService = new SignUpServiceImpl();
        //signUpService.saveAndValidate(signUpdto);
        //For multiple elements
List<SignUpdto> sign = new ArrayList<>();
sign.add(new SignUpdto("Akash", "akash@gmail.com", "Akash"));
sign.add(new SignUpdto("Ramesh", "Ramesh@gmail.com","Ramesh"));
sign.add(new SignUpdto("Suresh", "Suresh@gmail.com","Suresh"));
   SignUpService signUpService2 = new SignUpServiceImpl();
   signUpService2.saveAndValidateAll(sign);

   //For finding the entity by id
   SignUpService signUpService3 = new SignUpServiceImpl();
   SignUpdto signUpdto2 = signUpService2.findSignUpEntity(2);
   System.out.println(signUpdto2);
        System.out.println("list of entities"+sign);
        //For finding the entity by name
        SignUpService signUpService4 = new SignUpServiceImpl();
        SignUpdto signUpdto3 = signUpService4.findSignUpEntityByName("Akash");
        System.out.println(signUpdto3);
        //For finding the entity by name
        SignUpService signUpService5 = new SignUpServiceImpl();
        SignUpdto signUpdto4 = signUpService5.findSignUpEntityByName("Ramesh");
        System.out.println(signUpdto4);
        //For finding the entity by name
        SignUpService signUpService6 = new SignUpServiceImpl();
        SignUpdto signUpdto5 = signUpService6.findSignUpEntityByName("Suresh");
        System.out.println(signUpdto5);
    }
}
