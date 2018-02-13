package com.hospitalportal1.hospitalportal1.Entity;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "patientname")
    private String patientname;

    @Column(name = "registrationstatus")
    private Integer registrationstatus;

    public Patient() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public Integer getRegistrationstatus() {
        return registrationstatus;
    }

    public void setRegistrationstatus(Integer registrationstatus) {
        this.registrationstatus = registrationstatus;
    }

//    @OneToMany(mappedBy = "patient")
//    private List<Appointment> appointment;
//
//    public List<Appointment> getAppointment() {
//        return appointment;
//    }
//
//    public void setAppointment(List<Appointment> appointment) {
//        this.appointment = appointment;
//    }
}
