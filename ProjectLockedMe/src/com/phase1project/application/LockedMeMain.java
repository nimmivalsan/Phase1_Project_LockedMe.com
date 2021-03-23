package com.phase1project.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import com.phase1project.model.LockedMeUserCredentials;
import com.phase1project.model.LockedMeUsers;


public class LockedMeMain {
	
	private static Scanner keyboardValues;
	private static Scanner inputValues;
	private static Scanner lockedMeInput;
	
	private static PrintWriter output;
	private static PrintWriter lockedMeOutput;
	
	private static LockedMeUsers users;
	private static LockedMeUserCredentials usercreds;
	
	public static void main(String[] args) {
		
		initialize();
		welcomeScreen();
		userInteractions();
		
		
	}
	
	public static void initialize() {

		File  dbFile = new File("files.txt");
		File  lockerFile = new File("lockMeFiles.txt");
		
		try {
			//read data from db file
			inputValues = new Scanner(dbFile);
			
			//red data from locker file
			lockedMeInput = new Scanner(lockerFile);
			
			//read data from keyboard
			keyboardValues = new Scanner(System.in);
			
			//out put 
			output = new PrintWriter( new FileWriter(dbFile,true));
			lockedMeOutput = new PrintWriter( new FileWriter(lockerFile,true));
			
			users=new LockedMeUsers();
			usercreds=new LockedMeUserCredentials();
			
			
			
		} catch (IOException e) {
			System.out.println("404 : File Not Found ");
		}
		
	}
	
	
	public static void welcomeScreen() {
		System.out.println("-----------------------------------------");
		System.out.println("#					#");
		System.out.println("*   Welcome To LockedMe.com		*");
		System.out.println("*					*");
		System.out.println("*   Developed By: Nimmi Valsan		*");
		System.out.println("#					#");
		System.out.println("------------------------------------------");
		
	}
	
	public static void userInteractions() {
		System.out.println("------------------------------------------");
		System.out.println("If you are new here, press 1");
		System.out.println("For SignIn Press 2");
		System.out.println("1 . Registration ");
		System.out.println("2 . Sign In ");
		System.out.println("------------------------------------------");
		int option = keyboardValues.nextInt();
		switch(option) {
			case 1 : 
				registerUser();
				break;
			case 2 :
				signInUser();
				break;
			default :
				System.out.println("Please select either  1 or 2");
				break;
		}
		keyboardValues.close();
		inputValues.close();
	}
	
	
	public static void lockerOptions(String inpUsername) {
		System.out.println("Select one of the options below:");
		System.out.println("1 . GET ALL FILES");
		System.out.println("2 . ADD FILES ");
		System.out.println("3 . DELETE FILES ");
		System.out.println("4 . SEARCH FILES ");
		int option = keyboardValues.nextInt();
		switch(option) {
			case 1 : 
				fetchCredentials(inpUsername);
				break;
			case 2 :
				storeCredentials(inpUsername);
				break;
			case 3 :
				deleteCredentials(inpUsername);
				break;
			case 4 :
				searchCredentials(inpUsername);
				break;
			default :
				System.out.println("Please select one of the options");
				break;
		}
		lockedMeInput.close();
	}
	
	

	private static void searchCredentials(String inpUsername) {
		System.out.println("Enter sitename");
		String site = keyboardValues.next();
		
		boolean found = false;
		while(lockedMeInput.hasNext() && !found) {
			if(lockedMeInput.next().equals(inpUsername)) {
				//System.out.println("Search success");
				//String inpPassword = keyboardValues.next();
				if(lockedMeInput.next().equals(site)) {
					System.out.println("Search Successful");
					found = true;
					System.out.println("Site Name: "+lockedMeInput.next());
					System.out.println("Username: "+lockedMeInput.next());
					System.out.println("Password: "+lockedMeInput.next());
					
				}
			}
		}
		
	}

	private static void deleteCredentials(String inpUsername) {
		
		System.out.println("Enter sitename");
		String siteName = keyboardValues.next();
		usercreds.setSiteName(siteName);
		
		while(lockedMeInput.hasNext()) {

			if(lockedMeInput.next().equals(siteName)) {
				//usercreds.setUsername(null);
			System.out.println("Delete successful");
			}
		}
		
	}

	
	
	
	
	public static void storeCredentials(String loggedInUser) {
//		System.out.println("------------------------------------------");
//	//	System.out.println("*					*");
//		System.out.println("*   WELCOME TO LOCKEDME.COM	 *");
//	//	System.out.println("*					*");
//		System.out.println("-------------------------------------------");
		
		usercreds.setSignedInUser(loggedInUser);
		
		System.out.println("Enter Site Name :");
		String siteName = keyboardValues.next();
		usercreds.setSiteName(siteName);
		
		System.out.println("Enter Username :");
		String username = keyboardValues.next();
		usercreds.setUsername(username);
		
		System.out.println("Enter Password :");
		String password = keyboardValues.next();
		usercreds.setPassword(password);
		
	//	java.util.LinkedList<LockedMeUserCredentials> credentials= new java.util.LinkedList<LockedMeUserCredentials>();
	//	credentials.add(usercreds);
		
		lockedMeOutput.println(usercreds.getSignedInUser());
		lockedMeOutput.println(usercreds.getSiteName());
		lockedMeOutput.println(usercreds.getUsername());
		lockedMeOutput.println(usercreds.getPassword());
		
		System.out.println("Your credentials are stored successfully!");
		lockedMeOutput.close();		
	}
	
	
	public static void fetchCredentials(String inpUsername) {
//		System.out.println("-----------------------------------------");
//		System.out.println("*					*");
//		System.out.println("*   WELCOME TO LOCKEDME.COM	 *");
		System.out.println("   Your credentials are 	 ");
//		System.out.println("*					*");
//		System.out.println("------------------------------------------");
		System.out.println(inpUsername);
		
		
		while(lockedMeInput.hasNext()) {

			if(lockedMeInput.next().equals(inpUsername)) {
				System.out.println("Site Name: "+lockedMeInput.next());
				System.out.println("Username: "+lockedMeInput.next());
				System.out.println("Password: "+lockedMeInput.next());
			}
		}
		
	}
	
	
	public static void registerUser() {
		System.out.println("-----------------------------------------");
	//	System.out.println("*					*");
		System.out.println("*   WELCOME TO REGISTRATION PAGE	*");
	//	System.out.println("*					*");
		System.out.println("-----------------------------------------");
		
		System.out.println("Enter Username :");
		String username = keyboardValues.next();
		users.setUserName(username);
		
		System.out.println("Enter Password :");
		String password = keyboardValues.next();
		users.setPassword(password);
		
		output.println(users.getUserName());
		output.println(users.getPassword());
		
		System.out.println("Registration Successful !Your username is "+users.getUserName());
		System.out.println("Go back to main menu to Sign In");
		output.close();
		
	}
	
	
	public static void signInUser() {
		System.out.println("------------------------------------------");
		//System.out.println("#					*");
		System.out.println("*   WELCOME TO SIGN IN PAGE	 *");
		//System.out.println("*					*");
		System.out.println("------------------------------------------");
		System.out.println("Enter Username :");
		String inpUsername = keyboardValues.next();
		boolean found = false;
		while(inputValues.hasNext() && !found) {
			if(inputValues.next().equals(inpUsername)) {
				System.out.println("Enter Password :");
				String inpPassword = keyboardValues.next();
				if(inputValues.next().equals(inpPassword)) {
					System.out.println("Sign In Successful");
					found = true;
					lockerOptions(inpUsername);
					break;
				}
			}
		}
		if(!found) {
			System.out.println("User Not Found : Sign In Failure");
		}
		
	}

}
