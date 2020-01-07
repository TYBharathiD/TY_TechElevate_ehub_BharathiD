package com.tyss.ehub.dao;

import java.util.List;
import java.util.Map;

import com.tyss.ehub.dto.Billable;

public interface Billabledao {
	public boolean insert(Billable bill);

	public boolean delete(int bId);

	public boolean update(Billable empBill);

	public List<Billable> getAllBillable();
	
	public List<Billable> getBillable();

	public Map<String, Integer> getCountStack();
}
