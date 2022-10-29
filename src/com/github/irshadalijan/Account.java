package com.github.irshadalijan;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	private int accountNumber;
	private int pinNumber;
	private double currentBalance = 0;
	private double savingsBalance = 0;
	
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double calcCurrentWithdraw(double amount) {
		currentBalance = currentBalance - amount;
		return currentBalance;
	}
	
	public double calcSavingsWithdraw(double amount) {
		savingsBalance = savingsBalance - amount;
		return savingsBalance;
	}
	
	public double calcCurrentAddFunds(double amount) {
		currentBalance = currentBalance + amount;
		return currentBalance;
	}
	
	public double calcSavingsAddFunds(double amount) {
		savingsBalance = savingsBalance + amount;
		return savingsBalance;
	}
	
	public void getCurrentWithdrawFunds() {
		System.out.println("Available Balance: " + moneyFormat.format(currentBalance));
		System.out.print("\n Enter Amount you want to withdraw from Current Account: ");
		double amount = input.nextDouble();
		
		if((currentBalance - amount) >= 0) {
			calcCurrentWithdraw(amount);
			System.out.println("New Current Account Balance: "+ moneyFormat.format(currentBalance));
			
		}else {
			System.out.println("You cannot withdraw more than your balance amount");
		}
	}
	
	public void getSavingsWithdrawFunds() {
		System.out.println("Available Balance: " + moneyFormat.format(savingsBalance));
		System.out.print("\n Enter Amount you want to withdraw from Savings Account: ");
		double amount = input.nextDouble();
		
		if((currentBalance - amount) >= 0) {
			calcSavingsWithdraw(amount);
			System.out.println("New Savings Account Balance: "+ moneyFormat.format(savingsBalance));
			
		}else {
			System.out.println("You cannot withdraw more than your balance amount");
		}
	}
	
	public void getCurrentDepositFunds() {
		System.out.println("Available Balance: " + moneyFormat.format(currentBalance));
		System.out.print("\n Enter Amount you want to Deposit to your Current Account: ");
		double amount = input.nextDouble();
		
		if((currentBalance + amount) >= 0) {
			calcCurrentAddFunds(amount);
			System.out.println("New Current Account Balance: "+ moneyFormat.format(currentBalance));
			
		}else {
			System.out.println("The amount cannot be negative");
		}
	}

	public void getSavingsDepositFunds() {
		System.out.println("Available Balance: " + moneyFormat.format(savingsBalance));
		System.out.print("\n Enter Amount you want to Deposit to your Savings Account: ");
		double amount = input.nextDouble();
		
		if((savingsBalance + amount) >= 0) {
			calcSavingsAddFunds(amount);
			System.out.println("New Savings Account Balance: "+ moneyFormat.format(savingsBalance));
			
		}else {
			System.out.println("The amount cannot be negative");
		}
	}
}
