package com.frozen.gasbooking.system.service;

import com.frozen.gasbooking.system.dto.GasBookdto;

import java.util.List;

public interface GasBookingService {
    public String saveAndValidate(GasBookdto gasBookdto);
    public String saveAndValidateall(List<GasBookdto> gasBookdtos);

    public GasBookdto getBookingById(String bookingId);

}
