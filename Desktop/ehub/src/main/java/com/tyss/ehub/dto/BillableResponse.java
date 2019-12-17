package com.tyss.ehub.dto;

import java.util.List;

import lombok.Data;

@Data
public class BillableResponse {
	private int statusCode;
	private String message;
	private String description;
	private Billable empBill;
	private List<Billable> listBill;
}
