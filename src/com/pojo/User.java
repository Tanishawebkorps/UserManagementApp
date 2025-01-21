package com.pojo;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private List<String> phoneNumbers;

    public User(String name, String email, List <String> phoneNumbers) {
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
    
    public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Phones: " + phoneNumbers;
    }
}
