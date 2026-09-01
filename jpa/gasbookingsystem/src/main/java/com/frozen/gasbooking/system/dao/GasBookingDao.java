package com.frozen.gasbooking.system.dao;

import com.frozen.gasbooking.system.entity.GasBookingEntity;

import java.util.List;

public interface GasBookingDao {
    Boolean save(GasBookingEntity gasBookingEntity);
    Boolean saveall(List<GasBookingEntity> gasBookingEntities);
    GasBookingEntity getBookingById(String bookingId);

    List<GasBookingEntity> getAllBookings();
}
