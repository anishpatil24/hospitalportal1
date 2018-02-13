package com.hospitalportal1.hospitalportal1.Repository;

import com.hospitalportal1.hospitalportal1.Entity.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

    @Query(value = "Select * from Appointment s where s.patientname=(Select Patient.patientname from Patient where Patient.id=:id)", nativeQuery = true)
    List<Appointment> findAllAppointments(@Param("id") Integer id);

    @Query(value = "Select * from Appointment s where s.patientname=(Select Patient.patientname from Patient where Patient.id=:id)" +
            " and " +
            "s.date=:date", nativeQuery = true)
    List<Appointment> findAllAppointmentsDate(@Param("id") Integer id, @Param("date") java.sql.Date date);

    @Query(value = "Select * from Appointment s where s.doctorname IN (Select Doctor.doctorname from Doctor where Doctor.hospitalid=:id)", nativeQuery = true)
    List<Appointment> findAllAppointmentsForHospital(@Param("id") Integer id);

    @Query(value = "Select * from Appointment s where s.doctorname IN (Select Doctor.doctorname from Doctor where Doctor.hospitalid=:id) and s.date=:date", nativeQuery = true)
    List<Appointment> findAllAppointmentsForHospitalDate(@Param("id") Integer id, @Param("date") java.sql.Date date);

    @Query(value = "Select * from Appointment s where s.doctorname IN (Select Doctor.doctorname from Doctor where Doctor.doctorname=:doctorname and Doctor.hospitalid=:id)", nativeQuery = true)
    List<Appointment> findAllAppointmentsForDoctor(@Param("id") Integer id, @Param("doctorname") String doctorname);

    @Query(value = "Select  sum(doctorfees) from Doctor where Doctor.doctorname=(Select Appointment.doctorname from Appointment )", nativeQuery = true)
    Integer findTotalEarningsForDate(@Param("date") java.sql.Date date);
}
