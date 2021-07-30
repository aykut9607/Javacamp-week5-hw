package nLayered.core;

import nLayered.entities.concretes.Customer;
import nLayered.google.GoogleLoginManager;

public class GoogleLoginManagerAdapter implements ILoginService{

		GoogleLoginManager googleLoginManager=new GoogleLoginManager();
		
		
		@Override
		public void signUp(Customer customer) {
			googleLoginManager.signUp(customer.getMail(), customer.getPassword());
			
		}
		@Override
		public void signIn(Customer customer) {
			googleLoginManager.singIn(customer.getMail(), customer.getPassword());
			
		}
	

	

}
