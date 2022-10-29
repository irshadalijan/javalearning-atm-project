package com.github.irshadalijan;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
	
	public void getLogin() throws IOException {
		boolean tryAgain = false;
		do {
			try {
				data.put(123456, 1111);
				data.put(654321, 2222);
				data.put(122122, 3333);
				
				System.out.println("Welcome to Your Dummy ATM");
				
				System.out.print("Enter your Account number: ");
				setAccountNumber(menuInput.nextInt());
				
				System.out.print("Enter your PIN number: ");
				setPinNumber(menuInput.nextInt());
				
			}catch(Exception e) {
				System.out.println("\n"+"Invalid Character, only numbers are allowed."+"\n");
				tryAgain = true;
				
			}
			int acc = getAccountNumber();
			int pinNum = getPinNumber();
			if(data.containsKey(acc) && data.get(acc) == pinNum) {
				getAccountType();
				
			}else {
				System.out.println("\n"+"Wrong Account Number or Pin Number, Please try again"+"\n");
			}
		} while(!tryAgain);
	}
	
	public void getAccountType() {
		System.out.println("Select Account Type: ");
		System.out.println("Type 1 - Current Account");
		System.out.println("Type 2 - Savings Account");
		System.out.println("Type 3 -  Exit");
		
		int selection = menuInput.nextInt();
		switch(selection) {
		case 1:
			getCurrent();
			break;
			
		case 2: 
			getSavings();
			break;
			
		case 3:
			System.out.println("Thank you for using ATM, Good Bye. \n");
			break;
		
		default:
			System.out.println("\n"+"Invalid Choice"+"\n");
			getAccountType();
		}
	}

	public void getCurrent() {
		System.out.println("********************************");
		System.out.println("********Current Account*********");
		System.out.println("********************************");
		System.out.println(" Type 1 -  Check Balance");
		System.out.println(" Type 2 -  Withdraw Funds");
		System.out.println(" Type 3 -  Add Funds");
		System.out.println(" Type 4 -  Exit");
		System.out.print("Enter Choice: ");
		
		int sel = menuInput.nextInt();
		
		switch(sel) {
		case 1:
			System.out.println("Available Balance: " + moneyFormat.format(getCurrentBalance()));
			getAccountType();
			break;
		case 2:
			getCurrentWithdrawFunds();
			getAccountType();
			break;
		
		case 3:
			getCurrentDepositFunds();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this dummy ATM, Good Bye.");
		default:
			System.out.println("\n"+"Invalid Choice"+"\n");
			getCurrent();
		}
	}

	public void getSavings() {
		System.out.println("********************************");
		System.out.println("********Savings Account*********");
		System.out.println("********************************");
		System.out.println(" Type 1 -  Check Balance");
		System.out.println(" Type 2 -  Withdraw Funds");
		System.out.println(" Type 3 -  Add Funds");
		System.out.println(" Type 4 -  Exit");
		System.out.print("Enter Choice: ");
		
		int sel = menuInput.nextInt();
		
		switch(sel) {
		case 1:
			System.out.println("Available Balance for Savings Account: " + moneyFormat.format(getSavingsBalance()));
			getAccountType();
			break;
		case 2:
			getSavingsWithdrawFunds();
			getAccountType();
			break;
		
		case 3:
			getSavingsDepositFunds();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this dummy ATM, Good Bye.");
		default:
			System.out.println("\n"+"Invalid Choice"+"\n");
			getSavings();
		}
	}
}
