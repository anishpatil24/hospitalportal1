package com.hospitalportal1.hospitalportal1.service;

import com.hospitalportal1.hospitalportal1.Entity.Appointment;
import com.hospitalportal1.hospitalportal1.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    public List<Appointment> fetchAllAppointments(Integer id) {
        List<Appointment> appointment = appointmentRepository.findAllAppointments(id);
        try {
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Appointment> fetchAllAppointmentsDateForPatient(Integer id, String date) {
        Date d = new Date(date);
        java.sql.Date sDate = new java.sql.Date(d.getTime());
        List<Appointment> appointment = appointmentRepository.findAllAppointmentsDate(id, sDate);
        try {
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    public Integer delete(Integer id) {
        try {
            appointmentRepository.deleteById(id);
        } catch (Exception e) {
            return null;
        }
        return 1;
    }
}

