package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Depatment;
import entities.HouerContract;
import entities.Worker;
import entities.enuns.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.println("Name: ");
		String workerName = sc.nextLine();	
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Depatment(departmentName));
		

		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HouerContract contract = new HouerContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Enter moth and year too calculate income (MM/YYYY): ");
		String mothAndYear = sc.next();
		int month = Integer.parseInt(mothAndYear.substring(0, 2));
		int year = Integer.parseInt(mothAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: "+ worker.getDepartment().getName());
		System.out.println("Income for " + mothAndYear + ": " + String.format("%.2f" , worker.income(year, month)));
		
		
		sc.close();
		
		
	}

}
