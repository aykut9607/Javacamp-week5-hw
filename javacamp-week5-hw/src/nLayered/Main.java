package nLayered;

import nLayered.business.concretes.CustomerCheckManager;
import nLayered.business.concretes.CustomerManager;
import nLayered.business.concretes.CustomerVerificationManager;
import nLayered.core.GoogleLoginManagerAdapter;
import nLayered.core.ILoginService;
import nLayered.dataAccess.concretes.HibernateCustomerDao;
import nLayered.entities.concretes.Customer;

public class Main {
	public static void main(String[] args) {
	Customer customer1=new Customer(1,"aykut","demir","aykut@gmail.com","123321");
	Customer customer2=new Customer(2,"demir","aykut","demir@.com","123321");
	
	CustomerManager customerManager=new CustomerManager(
			new CustomerCheckManager(), 
			new CustomerVerificationManager(),
			new HibernateCustomerDao());
	
	customerManager.signUp(customer1);
	ILoginService loginService=new GoogleLoginManagerAdapter();
	loginService.signUp(customer2);

	}
}
