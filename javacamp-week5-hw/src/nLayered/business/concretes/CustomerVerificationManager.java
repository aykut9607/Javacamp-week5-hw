package nLayered.business.concretes;

import java.util.ArrayList;
import java.util.List;

import nLayered.business.abstracts.ICustomerVerifacationService;
import nLayered.entities.concretes.Customer;

public class CustomerVerificationManager implements ICustomerVerifacationService{
	
	CustomerCheckManager customerCheckManager;
	List<String> verificatedEmails = new ArrayList<String>();

	@Override
	public void sendMail(Customer customer, String mail) {
		System.out.println("Verifacation code  send to "+customer.getFirstName()+" "+customer.getLastName());
		
	}

	@Override
	public void verifyMail(Customer customer,String mail) {
		verificatedEmails.add(mail);
		System.out.println(customer.getFirstName()+" "+customer.getLastName()+"s mail is taken ");
	}
	
	@Override
	public boolean isVericatedMail(String mail) {
		
		if (verificatedEmails.contains(mail)) {
			return true;
		}
		return false;
	}

}
