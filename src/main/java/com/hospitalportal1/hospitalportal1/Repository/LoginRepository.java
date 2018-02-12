package com.hospitalportal1.hospitalportal1.Repository;

import com.hospitalportal1.hospitalportal1.Entity.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {


    @Query("Select s from  Login s where s.username=:username")
    Login findByUserName(@Param("username") String username);

}
