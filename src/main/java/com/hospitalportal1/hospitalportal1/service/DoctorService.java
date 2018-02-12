package com.hospitalportal1.hospitalportal1.service;

import com.hospitalportal1.hospitalportal1.Entity.Doctor;
import com.hospitalportal1.hospitalportal1.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public Integer create(String doctorname, Integer doctorfees, Integer hospitalid) {
        try {
            Doctor doctor = new Doctor();
            doctor.setDoctorname(doctorname);
            doctor.setDoctorfees(doctorfees);
            doctor.setHospitalid(hospitalid);
            doctorRepository.save(doctor);
            return 1;
        } catch (Exception e) {
            return null;
        }
    }

    public Integer modify(Integer doctorfees) {
        try {
            doctorRepository.modify(doctorfees);
            return 1;
        } catch (Exception e) {
            return null;
        }
    }

    public Integer delete(Integer id) {
        try {
            doctorRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            return null;
        }
    }
}
