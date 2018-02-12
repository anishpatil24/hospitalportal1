package com.hospitalportal1.hospitalportal1.Repository;

import com.hospitalportal1.hospitalportal1.Entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
    Patient findOneById(Integer id);
}
