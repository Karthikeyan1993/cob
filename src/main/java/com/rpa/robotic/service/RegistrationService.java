package com.rpa.robotic.service;

import com.rpa.robotic.entity.BankInformation;
import com.rpa.robotic.entity.Registration;

import java.util.List;

public interface RegistrationService {

	Registration SaveRegi(Registration r);

	Object finRegistration(Long id) throws InstantiationException, IllegalAccessException;

	Registration findRegi(Long id);

	BankInformation findBankIf(Long id);

	List<Registration> REGISTRATION_LIST();

	BankInformation SaveBankInformation(BankInformation bi);

}
