package com.tyss.ehub.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.ehub.dto.Billable;
import com.tyss.ehub.dto.BillableResponse;
import com.tyss.ehub.service.BillableService;

@RestController
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*",origins = "*")
@RequestMapping("/billable")
public class BillableController {
	@Autowired
	private BillableService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@PostMapping(path = "/billable", produces = MediaType.APPLICATION_JSON_VALUE)
	public BillableResponse addBillableEmp(@RequestBody Billable bill) {
		BillableResponse response = new BillableResponse();
		if (service.insert(bill)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully stored..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully stored..");
			response.getEmpBill();
		}
		return response;
	}

	@PutMapping(path = "/billable", produces = MediaType.APPLICATION_JSON_VALUE)
	public BillableResponse updateBillable(@RequestBody Billable bill) {
		BillableResponse response = new BillableResponse();
		if (service.update(bill)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully updated..");
			response.setListBill(Arrays.asList(bill));
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully updated..");
		}
		return response;
	}

	@DeleteMapping(path = "/billable/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BillableResponse deleteBillable(@PathVariable int bId) {
		BillableResponse response = new BillableResponse();
		if (service.delete(bId)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully deleted..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully deleted..");
		}
		return response;
	}

	@GetMapping(path = "/billable", produces = MediaType.APPLICATION_JSON_VALUE)
	public BillableResponse getAll() {
		BillableResponse response = new BillableResponse();
		List<Billable> list = service.getAllBillable();
		if (list == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully retrived");
			response.setListBill(list);
		}
		return response;
	}
}
