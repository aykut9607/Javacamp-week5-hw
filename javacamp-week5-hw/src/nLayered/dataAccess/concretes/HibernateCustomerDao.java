package nLayered.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import nLayered.dataAccess.abstracts.ICustomerDao;
import nLayered.entities.concretes.Customer;

public class HibernateCustomerDao implements ICustomerDao{
	
	List<Customer> customers = new ArrayList<Customer>();
	@Override
	public void add(Customer customer) {
		customers.add(customer);
		System.out.println(customer.getFirstName()+" "+customer.getLastName()+" saved to database");
	}

	@Override
	public void update(Customer customer) {	
		
	}
	
	@Override
	public void delete(Customer customer) {
		System.out.println(customer.getFirstName()+" "+customer.getLastName()+" saved to database");
		customers.remove(customer);
	}

	@Override
	public boolean getEmail(String email) {
		for(Customer customer:customers) {
			if(customer.getMail()==email) {
				return true;
				}
		}
		return false;
	}

	@Override
	public boolean getPassword(String password) {
		for(Customer customer:customers) {
			if(customer.getPassword()==password) {
				return true;
				}
		}
		return false;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}	
