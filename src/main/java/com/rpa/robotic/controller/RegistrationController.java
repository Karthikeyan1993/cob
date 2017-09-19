package com.rpa.robotic.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rpa.robotic.entity.BankInformation;
import com.rpa.robotic.entity.Registration;
import com.rpa.robotic.service.RegistrationService;
import com.rpa.robotic.utility.GeneratePdfReport;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService rs;

	@RequestMapping("/")
	public String GoHome() {
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String Home(Model model) {
		model.addAttribute("username", "Karthikeyan");
		return "index";
	}

	@RequestMapping(value = "/rsave", method = RequestMethod.POST)
	public String SaveRegi(Registration r, Model model) {
		Registration rData = rs.SaveRegi(r);
		model.addAttribute("refid", rData.getId());
		return "bank";
	}

	@RequestMapping(value = "/bisave", method = RequestMethod.POST)
	public String SaveBankInformation(BankInformation bi, Model model) {
		rs.SaveBankInformation(bi);
		return "success";
	}

	@RequestMapping(value = "/master", method = RequestMethod.GET)
	public String ViewMaster(Model model) {
		List<Registration> masterResult = rs.REGISTRATION_LIST();
		masterResult.forEach(r -> System.out.println(r));
		System.out.println(masterResult.size());
		model.addAttribute("ele", masterResult);
		return "master";
	}

	@RequestMapping(value = "/pdfreport/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> citiesReport(@PathVariable("id") Long id)
			throws IOException, NumberFormatException, InstantiationException, IllegalAccessException {
		Registration r = rs.findRegi(id);
		BankInformation bi = rs.findBankIf(id);
		ByteArrayInputStream bis = GeneratePdfReport.citiesReport(r, bi);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
}
