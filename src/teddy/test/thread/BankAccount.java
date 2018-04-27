package teddy.test.thread;

public class BankAccount {

	private String name;
	private int balance;
	
	public BankAccount() {
		name = "";
		balance = 0;
	}
	
	public BankAccount(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public void deposit(int number) {
		System.out.print("\n deposit " + number + " - balance before: " + balance);
		for (int i = 0; i < number; i++) {
			balance++;
		}
		System.out.print(" - after: " + balance + "\n");
	}
	
	public void widthdrawal(int number) {
		if (balance < number)
			return;
		
		System.out.print("\n widthdrawal " + number + " - balance before: " + balance);
		for (int i = 0; i < number; i++) {
			balance--;
		}
		System.out.print(" - after: " + balance + "\n");
	}
	
	public synchronized void depositSync(int number) {
		System.out.print("\n deposit " + number + " - balance before: " + balance);
		for (int i = 0; i < number; i++) {
			balance++;
		}
		System.out.print(" - after: " + balance + "\n");
	}
	
	public synchronized void widthdrawalSync(int number) {
		if (balance < number)
			return;
		
		System.out.print("\n widthdrawal " + number + " - balance before: " + balance);
		for (int i = 0; i < number; i++) {
			balance--;
		}
		System.out.print(" - after: " + balance + "\n");
	}
}
