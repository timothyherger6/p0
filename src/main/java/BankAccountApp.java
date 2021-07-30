import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BankAccountApp {
	static Scanner input = new Scanner(System.in);
	static CSVWriter writer;

	static {
		try {
			writer = new CSVWriter(new FileWriter("C:\\Users\\Lorraine Herger\\OneDrive\\Documents\\GitHub\\project0\\p0\\src\\main\\java\\accInfo.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String name, accType;
	int accNo, bal, amt;

	public BankAccountApp(String name, int accNo, String accType, int bal) {
		this.name = name;
		this.accNo = accNo;
		this.accType = accType;
		this.bal = bal;
	}

	public int Deposit() {
		System.out.print("Enter amount to deposit:");
		amt = input.nextInt();
		if (amt < 0) {
			System.out.println("Invalid Amount");
			return 1;
		}
		bal = bal + amt;
		System.out.println("New Balance: " + bal);
		return 0;
	}

	public int Withdraw() {
		System.out.println("Your Balance=" + bal);
		System.out.print("Enter amount to withdraw:");
		amt = input.nextInt();
		if (bal < amt) {
			System.out.println("Not sufficient balance.");
			return 1;
		}
		if (amt < 0) {
			System.out.println("Invalid Amount");
			return 1;
		}
		bal = bal - amt;
		System.out.println("New Balance: " + bal);
		return 0;
	}

	public void Display() {
		System.out.println("Name:" + name);
		System.out.println("Account No:" + accNo);
		System.out.println("Balance:" + bal);

	}

	public void DisplayBalance() {
		System.out.println("Balance:" + bal);
	}

	public static void main(String args[]) throws IOException {
		System.out.println("Enter your Name: ");
		String nn = input.nextLine();
		String[] nnStrArr = {nn};
 		writer.writeNext(nnStrArr);
		System.out.println("Enter Account Number: ");
		int num = input.nextInt();
		String[] numStr = {Integer.toString(num)};
		writer.writeNext(numStr);
		System.out.println("Enter Account Type: ");
		String type = input.next();
		String[] typeStrArr = {type};
		writer.writeNext(typeStrArr);
		System.out.println("Enter Initial Balance: ");
		int bal = input.nextInt();
		String[] balStr = {Integer.toString(bal)};
		writer.writeNext(balStr);
		writer.flush();
		System.out.println("Account Data entered into file \"accInfo.csv\"");
		BankAccountApp b1 = new BankAccountApp(nn, num, type, bal);
		int menu;
		System.out.println("Menu");
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Display Information");
		System.out.println("4. Exit");
		boolean quit = false;
		do {
			System.out.print("Please enter your choice: ");
			menu = input.nextInt();
			switch (menu) {
				case 1:
					b1.Deposit();
					break;

				case 2:
					b1.Withdraw();
					break;

				case 3:
					b1.Display();
					break;

				case 4:
					quit = true;
					break;
			}
		} while (!quit);
	}
}