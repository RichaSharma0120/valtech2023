package com.valtech.training.assignment.components;

public interface CompanyDAO {
	
	void addCompany(Company company);
	void updateCompany(Company company,int c_id);
	void deleteCompany(int c_id);
	int count();
	
	Company getById(int id);
	

}
