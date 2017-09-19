package com.rpa.robotic.service;

import com.rpa.robotic.entity.BankInformation;
import com.rpa.robotic.repository.BankInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpa.robotic.entity.Registration;
import com.rpa.robotic.repository.RegistrationRepository;

import java.lang.reflect.Field;
import java.util.List;

@Service("rs")
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository rr;
	@Autowired
	private BankInformationRepository bir;

	@Override
	public Registration SaveRegi(Registration r) {
		return rr.save(r);
	}

	@Override
	public Object finRegistration(Long id) throws InstantiationException, IllegalAccessException {
		Registration r = rr.findOne(id);
		BankInformation bi = bir.findOne(id);
		Object Obj = mergeObjects(r, bi);
		return Obj;
	}

	@Override
	public List<Registration> REGISTRATION_LIST() {
		return rr.findAll();
	}

	@Override
	public BankInformation SaveBankInformation(BankInformation bi) {
		return bir.save(bi);
	}

	@SuppressWarnings("unchecked")
	public static <T> T mergeObjects(T first, T second) throws IllegalAccessException, InstantiationException {
		Class<?> clazz = first.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Object returnValue = clazz.newInstance();
		for (Field field : fields) {
			field.setAccessible(true);
			Object value1 = field.get(first);
			Object value2 = field.get(second);
			Object value = (value1 != null) ? value1 : value2;
			field.set(returnValue, value);
		}
		return (T) returnValue;
	}

	@Override
	public Registration findRegi(Long id) {
		// TODO Auto-generated method stub
		return rr.findOne(id);
	}

	@Override
	public BankInformation findBankIf(Long id) {
		// TODO Auto-generated method stub
		return bir.findOne(id);
	}

}
