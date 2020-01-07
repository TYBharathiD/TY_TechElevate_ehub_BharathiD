package com.tyss.ehub.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tyss.ehub.dto.ClientsInfo;

public interface Clientdao {

	public boolean insert(ClientsInfo clientinfo, MultipartFile mfile);

	public boolean delete(int clientId);

	public boolean update(ClientsInfo clientinfo);

	public List<ClientsInfo> getAllClients();

}
