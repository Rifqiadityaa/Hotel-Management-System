import java.util.Scanner;

public class Start extends Thread {
	public Scanner scan = new Scanner(System.in);
	public String start = "Hotel Management System";

	Start() {
		start();
	}

	public void run() {
		try {
			for (int i = 0; i < start.length(); i++) {
				System.out.print(start.charAt(i));
				Thread.sleep(100);
			}
			System.out.println("\n\nPress enter to start...");
			scan.nextLine();
		} catch (InterruptedException e) {
			System.out.println("Program Interrupted");
		}
	}
}
