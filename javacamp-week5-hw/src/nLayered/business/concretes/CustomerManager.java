package nLayered.business.concretes;

import java.util.ArrayList;
import java.util.List;

import nLayered.business.abstracts.ICustomerCheckService;
import nLayered.business.abstracts.ICustomerService;
import nLayered.business.abstracts.ICustomerVerifacationService;
import nLayered.dataAccess.abstracts.ICustomerDao;
import nLayered.entities.concretes.Customer;

public class CustomerManager implements ICustomerService{

	ICustomerCheckService customerCheckService;
	ICustomerVerifacationService customerVerifacationService;
	ICustomerDao customerDao;
	
	public CustomerManager(
			ICustomerCheckService customerCheckService, 
			ICustomerVerifacationService customerVerifacationService,
			ICustomerDao customerDao) {
		this.customerCheckService = customerCheckService;
		this.customerVerifacationService = customerVerifacationService;
		this.customerDao = customerDao;
	}
	public void signIn(Customer customer) {
		customerVerifacationService.isVericatedMail(customer.getMail());

		if (customerDao.getEmail(customer.getMail()) && customerDao.getPassword(customer.getPassword())
				&& customerVerifacationService.isVericatedMail(customer.getMail()) == true) {
			System.out.println("User login successfully done.");} 
		
		else if (customerVerifacationService.isVericatedMail(customer.getMail()) == false) {
			System.out.println("User information is correct. But the login is not possible because the e-mail address is not verified.");
		} else {
			System.out.println("User information is incorrect, please check again.");
		}
		
	}

	@Override
	public void signUp(Customer customer) {
		if (customerCheckService.isValid(customer) == true) {
			System.out.print(customer.getFirstName() + " user has been successfully added to the system.\n");
			customerVerifacationService.sendMail(customer,customer.getMail());
			customerDao.add(customer);
		}
		
	}

}
