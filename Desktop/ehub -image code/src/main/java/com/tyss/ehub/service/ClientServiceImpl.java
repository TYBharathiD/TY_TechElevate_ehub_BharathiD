package com.tyss.ehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.ehub.dao.Clientdao;
import com.tyss.ehub.dto.ClientsInfo;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private Clientdao dao;

	@Override
	public boolean insert(ClientsInfo clientinfo, MultipartFile mfile) {
		return dao.insert(clientinfo,mfile);
	}

	@Override
	public boolean delete(int bid) {
		return dao.delete(bid);
	}

	@Override
	public boolean update(ClientsInfo clientinfo) {
		return dao.update(clientinfo);
	}

	@Override
	public List<ClientsInfo> getAllClients() {
		return dao.getAllClients();
	}

}
