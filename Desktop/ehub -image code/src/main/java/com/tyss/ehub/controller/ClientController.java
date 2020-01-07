package com.tyss.ehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.ehub.dto.ClientsInfo;
import com.tyss.ehub.dto.ClientsInfoStatusCode;
import com.tyss.ehub.service.ClientService;

@RestController
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*",origins = "*")
@RequestMapping("/clientinfo")
public class ClientController {

	@Autowired
	private ClientService service;

	@PostMapping(path = "/clientinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoStatusCode addclientsinfo(@RequestParam("mfile") MultipartFile mfile, @RequestHeader String clientName ,
			@RequestHeader String clienShortName ,
			@RequestHeader String deptName ,
			@RequestHeader String clientEmail ,
			@RequestHeader String compWebSite ,
			@RequestHeader String streetAddress ,
			@RequestHeader String addressLine2 ,
			@RequestHeader String city ,
			@RequestHeader String state ,
			@RequestHeader String country,
			@RequestHeader long clientNo,
			@RequestHeader int zipCode) {
		ClientsInfo clientsInfo=new ClientsInfo();
		clientsInfo.setAddressLine2(addressLine2);
		clientsInfo.setCity(city);
		clientsInfo.setClienShortName(clienShortName);
		clientsInfo.setClientEmail(clientEmail);
		clientsInfo.setClientName(clientName);
		clientsInfo.setClientNo(clientNo);
		clientsInfo.setCompWebSite(compWebSite);
		clientsInfo.setCountry(country);
		clientsInfo.setDeptName(deptName);
		clientsInfo.setState(state);
		clientsInfo.setStreetAddress(streetAddress);
		clientsInfo.setZipCode(zipCode);
		ClientsInfoStatusCode response = new ClientsInfoStatusCode();
		if (service.insert(clientsInfo,mfile)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully stored..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully stored..");
		}
		return response;
	}

	@DeleteMapping(path = "/clientinfo/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoStatusCode deleteclient(@PathVariable("clientId") int clientId) {
		ClientsInfoStatusCode response = new ClientsInfoStatusCode();
		if (service.delete(clientId)) {
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

	@GetMapping(path = "/clientinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoStatusCode getAll() {
		ClientsInfoStatusCode response = new ClientsInfoStatusCode();
		List<ClientsInfo> list = service.getAllClients();
		if (list == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully retrived");
			response.setListclients(list);
		}
		return response;
	}

	@PutMapping(path = "/clientinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientsInfoStatusCode updateclient(@RequestBody ClientsInfo cinfo) {
		ClientsInfoStatusCode response = new ClientsInfoStatusCode();
		if (service.update(cinfo)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully updated..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully updated..");
		}
		return response;
	}

}
