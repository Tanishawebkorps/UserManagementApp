package com.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.criteria.*;
import com.exception.UserNotFoundException;
import com.pojo.User;

public class Admin {
	Scanner sc = new Scanner(System.in);
	private Map<String, User> usersMap;

	public Admin() {
		usersMap = new HashMap<>();
	}

	public void addUser(Admin a) throws Exception {
		try {
			System.out.print("Enter name: ");
			String name = sc.next();
			System.out.print("Enter email: ");
			String email = sc.next();
			if (!Criteria.isValidEmail(email)) {
				throw new Exception("Invalid email format.");
			}
			if (usersMap.containsKey(email)) {
				throw new Exception("User already exists with this email.");
			}
			System.out.println("How many numbers would you like to add : ");
			int count = 0;
			try {
				count = sc.nextInt();
			} catch (InputMismatchException exc) {
				throw new Exception("please enter number only");
			}
			List<String> phone = new ArrayList<>();
			for (int i = 1; i <= count; i++) {
				System.out.print("Enter phone number: ");
				String p = sc.next();
				if (!Criteria.isValidPhoneNumber(p)) {
					throw new Exception("Invalid phone number format.");
				}
				phone.add(p);
			}
			User user = new User(name, email, phone);
			usersMap.put(email, user);
			System.out.println("User created successfully.");
			task(a);
		} 
		catch (Exception exc) {
			System.out.println(exc.getMessage());
			System.out.println("enter 1 for continue or other for going to admin pannel :");
			String c ="";
			c=sc.next();
			if (c.equals("1")) {
				addUser(a);
			}
			task(a);
		}
	}

	public void deleteUser(Admin a) throws Exception, UserNotFoundException {
		try {
			System.out.print("Enter email of user to delete: ");
			String email = sc.next();
			if (!Criteria.isValidEmail(email)) {
				throw new Exception("Invalid email format.");
			}
			if (!usersMap.containsKey(email)) {
				throw new UserNotFoundException("User with email " + email + " not found.");
			}
			usersMap.remove(email);
			System.out.println("User deleted successfully.");
			task(a);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			System.out.println("enter 1 for continue or other for going to admin pannel :");
			String c = sc.next();
			if (c.equals("1")) {
				deleteUser(a);
			}
			task(a);
		}
	}

	public void getUser(Admin a) throws Exception, UserNotFoundException {
		try {
			System.out.print("Enter email of user to fetch: ");
			String email = sc.next();
			if (!Criteria.isValidEmail(email)) {
				throw new Exception("Invalid email format.");
			}
			if (!usersMap.containsKey(email)) {
				throw new UserNotFoundException("User with email " + email + " not found.");
			}
			User u = usersMap.get(email);
			System.out.println(u);
			task(a);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			System.out.println("enter 1 for continue or  other for going to admin pannel :");
			String c = sc.next();
			if (c.equals("1")) {
				getUser(a);
			}
			task(a);
		}
	}

	public void getAllUsers(Admin a) {
		System.out.println("All Users: ");
		usersMap.forEach((key, value) -> System.out.println(value));
		task(a);
	}

	public void updateUserName(Admin a) throws Exception, UserNotFoundException {
		try {
			System.out.print("Enter email of user to update: ");
			String email = sc.next();
			if (!Criteria.isValidEmail(email)) {
				throw new Exception("Invalid email format.");
			}
			User user = usersMap.get(email);
			if (user == null) {
				throw new UserNotFoundException("User with email " + email + " not found.");
			}
			System.out.print("Enter new name: ");
			String newName = sc.next();
			user.setName(newName);
			usersMap.put(email, user);
			System.out.println("User Name updated successfully.");
			task(a);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			System.out.println("enter 1 for continue or  other for going to admin pannel :");
			String c = sc.next();
			if (c.equals("1")) {
				updateUserName(a);
			}
			task(a);
		}
	}

	public void addUserNum(Admin a) throws Exception, UserNotFoundException {
		try {
			System.out.print("Enter email of user to update: ");
			String email = sc.next();
			if (!Criteria.isValidEmail(email)) {
				throw new Exception("Invalid email format.");
			}
			User user = usersMap.get(email);
			if (user == null) {
				throw new UserNotFoundException("User with email " + email + " not found.");
			}
			System.out.println("How many numbers would you like to add : ");
			int j = 0;
			try {
				j = sc.nextInt();
			} catch (InputMismatchException exc) {
				throw new Exception("please enter number only");
			}
			List<String> newphone = new ArrayList<>();
			for (int i = 1; i <= j; i++) {
				System.out.print("Enter phone number: ");
				String phone = sc.next();
				if (!Criteria.isValidPhoneNumber(phone)) {
					throw new Exception("Invalid mobile number format.");
				}
				newphone.add(phone);
			}

			for (String p : newphone) {
				user.getPhoneNumbers().add(p);
			}
			usersMap.put(email, user);

			System.out.println("User Number Added Successfully.");
			task(a);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			System.out.println("enter 1 for continue or other for going to admin pannel :");
			String c = sc.next();
			if (c.equals("1")) {
				addUserNum(a);
			}
			task(a);
		}
	}

	public void updateUserNum(Admin a) throws Exception, UserNotFoundException {
		try {
			System.out.print("Enter email of user to update: ");
			String email = sc.next();
			if (!Criteria.isValidEmail(email)) {
				throw new Exception("Invalid email format.");
			}
			User user = usersMap.get(email);
			if (user == null) {
				throw new UserNotFoundException("User with email " + email + " not found.");
			}
			System.out.println("How many numbers would you like to add : ");
			int j = 0;
			try {
				j = sc.nextInt();
			} catch (InputMismatchException exc) {
				throw new Exception("please enter number only");
			}
			List<String> newphone = new ArrayList<>();
			for (int i = 1; i <= j; i++) {
				System.out.print("Enter phone number: ");
				String p = sc.next();
				if (!Criteria.isValidPhoneNumber(p)) {
					throw new Exception("Invalid mobile number format.");
				}
				newphone.add(p);
			}

			user.setPhoneNumbers(newphone);
			usersMap.put(email, user);
			System.out.println("User Number updated successfully.");
			task(a);
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			System.out.println("enter 1 for continue or other for going to admin pannel :");
			String c = sc.next();
			if (c.equals("1")) {
				updateUserNum(a);
			}
			task(a);
		}
	}

	public static void task(Admin a) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("\n--- Admin Panel ---");
			System.out.println("1. Create User");
			System.out.println("2. Delete User");
			System.out.println("3. Fetch User");
			System.out.println("4. Fetch All Users");
			System.out.println("5. Update User Name");
			System.out.println("6. Add User Number");
			System.out.println("7. update User Number");
			System.out.println("8. Exit");
			System.out.print("Enter your choice: ");
			int choice = 0;
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException exc) {
				throw new Exception("please enter number only");
			}

			switch (choice) {
			case 1:
				a.addUser(a);
				break;
			case 2:
				a.deleteUser(a);
				break;
			case 3:
				a.getUser(a);
				break;
			case 4:
				a.getAllUsers(a);
				break;
			case 5:
				a.updateUserName(a);
				break;
			case 6:
				a.addUserNum(a);
				break;
			case 7:
				a.updateUserNum(a);
				break;
			case 8:
				System.out.println("Exit....");
				System.exit(0);

			default:
				System.out.println("invalid choice");
				break;
			}
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
			task(a);
		}
	}
}
