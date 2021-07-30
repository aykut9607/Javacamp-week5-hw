package nLayered.business.concretes;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Pattern;

import nLayered.business.abstracts.ICustomerCheckService;
import nLayered.entities.concretes.Customer;

public class CustomerCheckManager implements ICustomerCheckService{
	List<String> listOfEmail = new ArrayList<String>();
	
	@Override
	public boolean checkFirstName(Customer customer) {
		if(customer.getFirstName().isEmpty()) {
				System.out.println("please do not leave the name blank");
				return false;
		}
		else {
			if(customer.getFirstName().length()<3) {
				System.out.println("please enter name, at least three characters");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkLastName(Customer customer) {
		if(customer.getLastName().isEmpty()) {
			System.out.println("please do not leave the name blank");
			return false;
	}
	else {
		if(customer.getLastName().length()<3) {
			System.out.println("please enter lastname, at least three characters");
			return false;
		}
	}
	return true;
	}

	@Override
	public boolean checkEmail(Customer customer) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		if (customer.getMail().isEmpty()) {
			System.out.println("Email alanı boş bırakılamaz.");
			return false;
		} else {
			if (pattern.matcher(customer.getMail()).find() == false) {
				System.out.println("The e-mail address entered is not suitable for the format. Example: example@example.com");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkPassword(Customer customer) {
		if(customer.getPassword().isEmpty()) {
			System.out.println("please do not leave the name blank");
			return false;
	}
	else {
		if(customer.getPassword().length()<6) {
			System.out.println("please enter password, at least three characters");
			return false;
		}
	}
	return true;
	}

	@Override
	public boolean uniqueEmail(Customer customer) {
		boolean result=true;
		if (listOfEmail.contains(customer.getMail())) {
			System.out.println("Please try a different e-mail address. This e-mail address has already been registered in the system,");
			result=false;
		}else{
			result=true;
			listOfEmail.add(customer.getMail());
		}		
		return result;
	}

	@Override
	public boolean isValid(Customer customer) {
		if (checkFirstName(customer) && checkLastName(customer) && checkEmail(customer) && checkPassword(customer)
				&& uniqueEmail(customer) == true) {
			return true;
		}
		return false;
	}

}
