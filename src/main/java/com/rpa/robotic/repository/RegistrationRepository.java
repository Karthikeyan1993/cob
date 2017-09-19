package com.rpa.robotic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rpa.robotic.entity.Registration;

@Repository("rr")
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
