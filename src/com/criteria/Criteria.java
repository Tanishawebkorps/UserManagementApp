package com.criteria;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Criteria {
	public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9. _%+-]+@[a-zA-Z0-9. -]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^[6-9][0-9]{9}$"; 
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
//    public static boolean choose() throws Exception {
//    	System.out.println("enter 1 for continue or 2 for going to admin pannel :");
//    	Scanner sc=new Scanner(System.in);
//    	int c=0;
//    	try {
//    	c=sc.nextInt();
//    	}
//    	catch(Exception exc) {
//    		throw new Exception("please enter number only ");
//    	}
//    	if(c==1) {
//    		return true;
//    	}
//    	else {
//    		return false;
//    	}   	
//    }
}
