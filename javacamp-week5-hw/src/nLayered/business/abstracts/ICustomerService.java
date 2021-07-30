package nLayered.business.abstracts;

import nLayered.entities.concretes.Customer;

public interface ICustomerService {
	void signIn(Customer customer);
	void signUp(Customer customer);
}
