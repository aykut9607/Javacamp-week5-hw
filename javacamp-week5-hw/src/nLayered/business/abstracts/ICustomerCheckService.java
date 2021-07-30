package nLayered.business.abstracts;

import nLayered.entities.concretes.Customer;

public interface ICustomerCheckService {
	boolean checkFirstName(Customer customer);
	boolean checkLastName(Customer customer);
	boolean checkEmail(Customer customer);
	boolean checkPassword(Customer customer);
	boolean uniqueEmail(Customer customer);
	boolean isValid(Customer customer);
}
