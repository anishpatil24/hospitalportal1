package com.hospitalportal1.hospitalportal1.controller;

import com.hospitalportal1.hospitalportal1.Entity.Appointment;
import com.hospitalportal1.hospitalportal1.service.AppointmentEntryService;
import com.hospitalportal1.hospitalportal1.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    AppointmentService appointmentService;
    @Autowired
    AppointmentEntryService appointmentEntryService;

    @RequestMapping(value = "/rest/fetchAllAppointments", method = RequestMethod.POST)
    @ResponseBody
    public List<Appointment> handleFetchAllAppointments(@RequestParam(value = "id") Integer id) {

        List<Appointment> appointment = appointmentService.fetchAllAppointments(id);
        try {
            return appointment;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @RequestMapping(value = "/rest/fetchAllAppointmentsOnDate", method = RequestMethod.POST)
    @ResponseBody
    public List<Appointment> handleFetchAllAppointmentsDateForPatient(@RequestParam Integer id, @RequestParam String date) {
        List<Appointment> appointment = appointmentService.fetchAllAppointmentsDateForPatient(id, date);
        try {
            return appointment;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @RequestMapping(value = "/rest/bookAppointment", method = RequestMethod.POST)
    @ResponseBody
    public String handleBookAppointment(@RequestParam Integer idPatient, @RequestParam String date, @RequestParam Integer idDoctor) {
        Integer isBooked = appointmentEntryService.insert(idPatient, date, idDoctor);
        if (isBooked == 1)
            return "Success";
        return null;
    }

    @RequestMapping(value = "/rest/cancelAppointment", method = RequestMethod.DELETE)
    @ResponseBody
    public String handleCancelAppointment(@RequestParam Integer id) {
        Integer isCancelled = appointmentService.delete(id);
        if (isCancelled == 1)
            return "Successfully Cancelled";
        return null;
    }

}
