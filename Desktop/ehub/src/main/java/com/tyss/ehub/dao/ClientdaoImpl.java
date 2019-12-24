package com.tyss.ehub.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tyss.ehub.dto.ClientsInfo;

@Repository
public class ClientdaoImpl implements Clientdao {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean insert(ClientsInfo clientinfo) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(clientinfo);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int clientId) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		ClientsInfo clients = manager.find(ClientsInfo.class, clientId);
		if (clients == null) {
			return false;
		}
		transaction.begin();
		manager.remove(clients);
		transaction.commit();
		return true;
	}

	@Override
	public boolean update(ClientsInfo clientinfo) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		ClientsInfo clients1 = manager.find(ClientsInfo.class, clientinfo.getClientId());
		if (clients1 == null) {
			return false;
		}
		transaction.begin();
		clients1.setClientId(clientinfo.getClientId());
		clients1.setClienShortName(clientinfo.getClienShortName());
		clients1.setAddressLine2(clientinfo.getAddressLine2());
		clients1.setClientEmail(clientinfo.getClientEmail());
		clients1.setClientName(clientinfo.getClientName());
		clients1.setClientNo(clientinfo.getClientNo());
		clients1.setClientLogo(clientinfo.getClientLogo());
		clients1.setState(clientinfo.getState());
		clients1.setCity(clientinfo.getCity());
		clients1.setDeptName(clientinfo.getDeptName());
		clients1.setCompWebSite(clientinfo.getCompWebSite());
		clients1.setCountry(clientinfo.getCountry());
		clients1.setStreetAddress(clientinfo.getStreetAddress());
		clients1.setZipCode(clientinfo.getZipCode());
		transaction.commit();
		return true;
	}

	@Override
	public List<ClientsInfo> getAllClients() {
		EntityManager manager = emf.createEntityManager();

		String get = "from ClientsInfo";
		Query query = (Query) manager.createQuery(get);
		List<ClientsInfo> list = query.getResultList();
		if (list == null) {
			return null;
		}
		return list;
	}

}
