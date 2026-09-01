package com.frozen.gasbooking.system.serviceimpl;

import com.frozen.gasbooking.system.dao.GasBookingDao;
import com.frozen.gasbooking.system.daoimpl.GasBookingDaoImpl;
import com.frozen.gasbooking.system.dto.GasBookdto;
import com.frozen.gasbooking.system.entity.GasBookingEntity;
import com.frozen.gasbooking.system.service.GasBookingService;

import java.util.List;

public class GasBookingServiceImpl implements GasBookingService {
    private GasBookingDao gasBookingDao = new GasBookingDaoImpl();

    @Override
    public String saveAndValidate(GasBookdto gasBookdto) {
       String isSaved = null;
       if(gasBookdto != null) {
           GasBookingEntity  gasBookingEntity = new GasBookingEntity();
           gasBookingEntity.setBookingId(gasBookdto.getBookingId());
           gasBookingEntity.setBookingAmount(gasBookdto.getBookingAmount());
           gasBookingEntity.setCompany(gasBookdto.getCompany());
           Boolean saved = gasBookingDao.save(gasBookingEntity);
         if (saved) {
             isSaved = "Data Saved";
         }  else
             {
                 isSaved = "Data Not Saved";
             }
           return isSaved;
       }
        return null;
    }

    @Override
    public String saveAndValidateall(List<GasBookdto> gasBookdtos) {
        return "";
    }

    @Override
    public GasBookdto getBookingById(String bookingId) {
        System.out.println("GasBookingServiceImpl.getBookingById() called with bookingId: " + bookingId);
        GasBookingEntity gasBookingEntity = gasBookingDao.getBookingById(bookingId);
        if (gasBookingEntity != null) {
            GasBookdto gasBookdto = new GasBookdto();
            gasBookdto.setBookingId(gasBookingEntity.getBookingId());
            gasBookdto.setBookingAmount(gasBookingEntity.getBookingAmount());
            gasBookdto.setCompany(gasBookingEntity.getCompany());
            return gasBookdto;
        }
        else {
            System.out.println("No booking found with ID: " + bookingId);
        }
        return null;
    }
}
