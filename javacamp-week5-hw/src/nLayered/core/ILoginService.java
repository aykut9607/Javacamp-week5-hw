package nLayered.core;

import nLayered.entities.concretes.Customer;

public interface ILoginService {
		
		public void signUp(Customer customer);
		public void signIn(Customer customer);

}
