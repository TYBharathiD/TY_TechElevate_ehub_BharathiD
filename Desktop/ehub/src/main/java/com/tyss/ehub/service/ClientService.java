package com.tyss.ehub.service;

import java.util.List;

import com.tyss.ehub.dto.ClientsInfo;

public interface ClientService {

	public boolean insert(ClientsInfo clientinfo);

	public boolean delete(int bid);

	public boolean update(ClientsInfo clientinfo);

	public List<ClientsInfo> getAllClients();
	
}
