package com.tyss.ehub.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tyss.ehub.dto.ClientsInfo;

public interface ClientService {

	public boolean insert(ClientsInfo clientinfo, MultipartFile mfile);

	public boolean delete(int bid);

	public boolean update(ClientsInfo clientinfo);

	public List<ClientsInfo> getAllClients();
	
}
