package com.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.service.Admin;

public class AppMain {
	public static void main(String args[]) {
		Admin a = new Admin();
        Admin.task(a);
	}
}
