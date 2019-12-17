package com.tyss.ehub.dao;

import java.util.List;

import com.tyss.ehub.dto.Billable;

public interface Billabledao {
	public boolean insert(Billable bill);

	public boolean delete(int bId);

	public boolean update(Billable empBill);

	public List<Billable> getAllBillable();
}
