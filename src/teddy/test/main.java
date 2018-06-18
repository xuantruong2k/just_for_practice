package teddy.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Vector;

import teddy.test.thread.*;

public class main {
	

	public static void main(String[] args) {
		
		Solution sol = Solution.getInstance();
		sol.permute("ABCD");
		
		// TODO Auto-generated method stub

//		Solution instance = Solution.getInstance();
//		instance.runSearchIndexInSortedArray();
		
		//KeyInfo.getInstance().runTest();
		
//		PrintMachine pm = new PrintMachine();
//		
//		Thread t1 = new Thread() {
//			public void run() {
//				pm.printSync("thread 1", 200);
//				//pm.print("thread 1 NONE", 20);
//			}
//		};
//		
//		Thread t2 = new Thread() {
//			public void run() {
//				pm.printSync("thread 2", 200);
//				//pm.print("thread 2 NONE", 40);
//			}
//		};
//		
//		Thread t3 = new Thread() {
//			public void run() {
//				pm.printSync("thread 3", 200);
//				//pm.print("thread 3 NONE", 30);
//			}
//		};
//		
//		t1.start();
//		t2.start();
//		t3.start();
		
		/// test thread in bank account
//		BankAccount ba = new BankAccount("truong", 10000);
//		
//		Thread t4 = new Thread() {
//			public void run() {
//				ba.widthdrawalSync(3000);
//			}
//		};
//		
//		Thread t5 = new Thread() {
//			public void run() {
//				ba.widthdrawalSync(5000);
//			}
//		};
//		
//		Thread t6 = new Thread() {
//			public void run() {
//				ba.widthdrawalSync(6000);
//			}
//		};
//		
//		t4.start();
//		t5.start();
//		t6.start();
	}
}
