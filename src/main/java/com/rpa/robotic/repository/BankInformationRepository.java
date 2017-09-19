package com.rpa.robotic.repository;

import com.rpa.robotic.entity.BankInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bir")
public interface BankInformationRepository extends JpaRepository <BankInformation, Long> {

}
