package com.example.coursebookingserver.service;

import com.example.coursebookingserver.exception.AppBasicException;
import com.example.coursebookingserver.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    List<Booking> getAllBookings();

    List<Booking> getBookingsByAppUserEmail(String email);

    void deleteBookingById(Long id);

    void assignCourse(Long courseId, Long appUserId)throws AppBasicException;
}
