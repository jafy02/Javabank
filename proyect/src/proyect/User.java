package proyect;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
	private String 	firstName;
	private String lastName;
	private String uuid;
	private byte pinHash[];
	private ArrayList<Account> accounts;
	
	public User( String firstName, String lastName, String pin, Bank theBank ){
		this.firstName=firstName;
		this.lastName=lastName;

	try {
		MessageDigest md= MessageDigest.getInstance("MDS");
		this.pinHash=md.digest(pin.getBytes());
	} catch (NoSuchAlgorithmException e) {
		System.err.println("Error, caugth NoSuchAlgorithmException ");
		e.printStackTrace();
		System.exit(1);
	}
	
	//get a new,unique universal ID for the user
	this.uuid=theBank.getNewUserUUID();
	
	//Create empty list of accounts 
	this.accounts= new ArrayList<Account>();
	
	
	System.out.printf("New user %s, %s with ID %s created.\n.", lastName ,
			firstName , this.uuid);
	
	}
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
}
