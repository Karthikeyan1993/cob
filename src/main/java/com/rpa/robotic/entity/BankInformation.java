package com.rpa.robotic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String acNumber;
	private String bankName;
	private String bankBranch;
	private String bankifsi;
	private String acType;
	private Long RegiRef;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcNumber() {
		return acNumber;
	}

	public void setAcNumber(String acNumber) {
		this.acNumber = acNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
	}

	public Long getRegiRef() {
		return RegiRef;
	}

	public void setRegiRef(Long regiRef) {
		RegiRef = regiRef;
	}

	public String getBankifsi() {
		return bankifsi;
	}

	public void setBankifsi(String bankifsi) {
		this.bankifsi = bankifsi;
	}

}
