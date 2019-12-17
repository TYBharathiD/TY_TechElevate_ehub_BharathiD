package com.tyss.ehub.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class Billable {
	@Id
	@GeneratedValue
	private int employeeId;
//	@JoinColumn(name = "clientId")
//	@ManyToOne(cascade = CascadeType.ALL)
//	private ClientsInfo clientId;
	@Column
	private Date deployementDate;
	@Column
	private Date contractEndDate;
	@Column
	private double rateCardPerMonth;
	@Column
	private String stack;
	@Column
	private String yoe;
}
