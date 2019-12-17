package com.tyss.ehub.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tyss.ehub.dto.Billable;
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
		clients1.setClientId(clients1.getClientId());
		clients1.setClientname(clients1.getClientname());
		clients1.setClientLogo(clients1.getClientLogo());
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
