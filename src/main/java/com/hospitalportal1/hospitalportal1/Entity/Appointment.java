package com.hospitalportal1.hospitalportal1.Entity;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "patientname")
    private String patientname;

    @Column(name = "doctorname")
    private String doctorname;

    @Column(name = "date")
    private java.sql.Date date;

    public Appointment() {
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

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    //    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "patientname")
//    private Patient patient;
//
//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }

}
