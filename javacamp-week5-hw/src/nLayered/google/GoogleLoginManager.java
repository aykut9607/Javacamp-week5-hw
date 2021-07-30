package nLayered.google;

public class GoogleLoginManager {
public void signUp(String email, String password) {
		
		System.out.println("Registered in the system with Google : " + email);
		
		singIn(email,password);
	}
	
	public void singIn(String email, String password) {
		
		System.out.println(email + " Signed in with Google account");
	}
}
