package com.tyss.ehub.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class ClientsInfo {
	@Id
	@Column
	@GeneratedValue
	private int clientId;
	@Column
	private String clientName;
	@Column
	private String clienShortName;
	@Column
	private String deptName;
	@Column
	private long clientNo;
	@Column
	private String clientEmail;
	@Column
	private String compWebSite;
	@Column
	private String clientLogo; // image storing
	@Column
	private String streetAddress;
	@Column
	private String addressLine2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private int zipCode;
	@Column
	private String country;

}
