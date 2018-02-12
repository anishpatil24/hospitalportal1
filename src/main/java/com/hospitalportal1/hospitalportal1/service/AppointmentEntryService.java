package com.hospitalportal1.hospitalportal1.service;

import com.hospitalportal1.hospitalportal1.Entity.Appointment;
import com.hospitalportal1.hospitalportal1.Entity.Doctor;
import com.hospitalportal1.hospitalportal1.Entity.Patient;
import com.hospitalportal1.hospitalportal1.Repository.AppointmentRepository;
import com.hospitalportal1.hospitalportal1.Repository.DoctorRepository;
import com.hospitalportal1.hospitalportal1.Repository.PatientRepository;
import com.hospitalportal1.hospitalportal1.model.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppointmentEntryService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AppointmentRepository appointmentRepository;

    public Integer insert(Integer idPatient, String date, Integer idDoctor) {
        try {
            Date d = new Date(date);
            java.sql.Date sDate = new java.sql.Date(d.getTime());
            PatientDto patientDto = new PatientDto();
            Patient patient = patientRepository.findOneById(idPatient);
//            patientDto.setId(patient.getId());
//            patientDto.setPatientname(patient.getPatientname());
//            patientDto.setRegistrationStatus(patient.getRegistrationstatus());
            String patientname = patientDto.getPatientname();
            Doctor doctor = doctorRepository.findByIdDoctor(idDoctor);
            String doctorname = doctor.getDoctorname();
            Appointment appointment = new Appointment();
            appointment.setPatientname(patientname);
            appointment.setDoctorname(doctorname);
            appointment.setDate(sDate);
            appointmentRepository.save(appointment);
            return 1;
        } catch (Exception e) {
            return null;
        }
    }

}
