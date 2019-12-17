package com.tyss.ehub.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class ClientsInfo {
	@Id
	@GeneratedValue
	private int clientId;
	@Column
	private String clientname;
	@Column
	private String clientLogo; // image storing

//	@OneToMany
//	@JoinColumn(name = "clientInfoId", nullable = false)
//	private List<ClientContactInfo> contactInfos;
	
//	@JoinColumn(name = "employeeId")
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Billable> billables;
}
