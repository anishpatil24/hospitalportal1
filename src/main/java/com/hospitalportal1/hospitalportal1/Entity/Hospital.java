package com.hospitalportal1.hospitalportal1.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "hospitalname")
    private String hospitalname;

    @Column(name = "registrationstatus")
    private Integer registrationstatus;

    public Hospital() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public Integer getRegistrationstatus() {
        return registrationstatus;
    }

    public void setRegistrationstatus(Integer registrationstatus) {
        this.registrationstatus = registrationstatus;
    }

}
