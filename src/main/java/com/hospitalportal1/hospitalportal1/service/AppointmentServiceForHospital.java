package com.hospitalportal1.hospitalportal1.service;

import com.hospitalportal1.hospitalportal1.Entity.Appointment;
import com.hospitalportal1.hospitalportal1.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceForHospital {

    @Autowired
    AppointmentRepository appointmentRepository;

    public List<Appointment> fetchAllAppointments(Integer id) {

        List<Appointment> appointment = appointmentRepository.findAllAppointmentsForHospital(id);
        try {
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Appointment> fetchAllAppointmentsDate(Integer id, String date) {
        try {
            Date d = new Date(date);
            java.sql.Date sDate = new java.sql.Date(d.getTime());
            List<Appointment> appointment = appointmentRepository.findAllAppointmentsForHospitalDate(id, sDate);
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Appointment> fetchAllAppointmentsForDoctor(Integer id, String doctorname) {
        List<Appointment> appointment = appointmentRepository.findAllAppointmentsForDoctor(id, doctorname);
        try {
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    public Integer cancel(Integer id) {
        try {
            appointmentRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            return null;
        }
    }

    public Integer fetchTotalEarningsForDate(String date) {
        Date d = new Date(date);
        java.sql.Date sDate = new java.sql.Date(d.getTime());
        Integer totalEarnings = appointmentRepository.findTotalEarningsForDate(sDate);
        return null;
    }
}
