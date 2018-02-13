package com.hospitalportal1.hospitalportal1.Entity;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "doctorname")
    private String doctorname;

    @Column(name = "doctorfees")
    private Integer doctorfees;

    @Column(name = "hospitalid")
    private Integer hospitalid;

    public Doctor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public Integer getDoctorfees() {
        return doctorfees;
    }

    public void setDoctorfees(Integer doctorfees) {
        this.doctorfees = doctorfees;
    }

    public Integer getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(Integer hospitalid) {
        this.hospitalid = hospitalid;
    }
}
