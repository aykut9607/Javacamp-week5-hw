package nLayered.business.abstracts;

import nLayered.entities.concretes.Customer;

public interface ICustomerVerifacationService {
	void sendMail(Customer customer,String mail);
	void verifyMail(Customer customer,String mail);
	boolean isVericatedMail(String mail);
}
