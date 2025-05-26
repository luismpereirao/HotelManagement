package com.hotelmanagement.services.interfac;

import com.hotelmanagement.dto.Response;
import com.hotelmanagement.entities.Booking;

public interface IBookingService {

    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);
}
