package com.hospitalportal1.hospitalportal1.Repository;

import com.hospitalportal1.hospitalportal1.Entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Integer>{

    @Query(value = "Select s from Doctor s where s.id=:id")
    Doctor findByIdDoctor(@Param("id") Integer id);

    @Query("Update Doctor set doctorfees=:doctorfees")
    void modify(@Param("doctorfees") Integer doctorfees);
}
