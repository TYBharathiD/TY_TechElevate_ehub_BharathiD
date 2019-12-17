package com.tyss.ehub.dao;

import java.util.List;

import com.tyss.ehub.dto.ClientsInfo;

public interface Clientdao {

	public boolean insert(ClientsInfo clientinfo);

	public boolean delete(int clientId);

	public boolean update(ClientsInfo clientinfo);

	public List<ClientsInfo> getAllClients();

}
