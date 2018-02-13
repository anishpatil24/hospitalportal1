package com.hospitalportal1.hospitalportal1.controller;

import com.hospitalportal1.hospitalportal1.Entity.Appointment;
import com.hospitalportal1.hospitalportal1.service.AppointmentEntryService;
import com.hospitalportal1.hospitalportal1.service.AppointmentServiceForHospital;
import com.hospitalportal1.hospitalportal1.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController {

    @Autowired
    AppointmentServiceForHospital appointmentServiceForHospital;
    @Autowired
    AppointmentEntryService appointmentEntryService;
    @Autowired
    DoctorService doctorService;

    @RequestMapping(value = "/rest/fetchAllAppointmentsForHospital", method = RequestMethod.POST)
    public List<Appointment> handleFetchAllAppointments(@RequestParam Integer id) {
        try {
            List<Appointment> appointment = appointmentServiceForHospital.fetchAllAppointments(id);
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/rest/fetchAllAppointmentsForHospitalDate", method = RequestMethod.POST)
    public List<Appointment> handleFetchAllAppointmentsDate(@RequestParam Integer id, @RequestParam String date) {
        try {
            List<Appointment> appointment = appointmentServiceForHospital.fetchAllAppointmentsDate(id,date);
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/rest/fetchAllAppointmentsForDoctor", method = RequestMethod.POST)
    public List<Appointment> handleFetchAllAppointmentsForDoctor(@RequestParam Integer id, @RequestParam String doctorname) {
        try {
            List<Appointment> appointment = appointmentServiceForHospital.fetchAllAppointmentsForDoctor(id, doctorname);
            return appointment;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/rest/createDoctor", method = RequestMethod.POST)
    public String handleCreateDoctor(@RequestParam String doctorname, @RequestParam Integer doctorfees, @RequestParam Integer hospitalid) {
        Integer created = doctorService.create(doctorname, doctorfees, hospitalid);
        if (created == 1)
            return "Successfully created";
        return null;
    }

    @RequestMapping(value = "/rest/modifyDoctor", method = RequestMethod.PUT)
    public String handleModifyDoctor(@RequestParam Integer doctorfees) {
        Integer modified = doctorService.modify(doctorfees);
        if (modified == 1)
            return "Successfully modified";
        return null;
    }

    @RequestMapping(value = "/rest/deleteDoctor", method = RequestMethod.DELETE)
    public String handleDeleteDoctor(@RequestParam(value = "id") Integer id) {
        Integer deleted = doctorService.delete(id);
        if (deleted == 1)
            return "Successfully deleted";
        return null;
    }

    @RequestMapping(value = "/rest/cancelAppointmentForHospital", method = RequestMethod.DELETE)
    public String handleCancelAppointment(@RequestParam(value = "id") Integer id) {
        Integer isCancelled = appointmentServiceForHospital.cancel(id);
        if (isCancelled == 1)
            return "Successfully cancelled";
        return null;
    }

    @RequestMapping(value = "/rest/totalEarningsForDate", method = RequestMethod.GET)
    public Integer handleTotalEarningsForDate(@RequestParam String date) {
        Integer totalEarning = appointmentServiceForHospital.fetchTotalEarningsForDate(date);
        return null;
    }
}