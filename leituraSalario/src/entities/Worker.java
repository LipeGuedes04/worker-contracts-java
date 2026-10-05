package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enuns.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Depatment department;
	private List<HouerContract> contracts = new ArrayList<>();
	
	public Worker() { 
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Depatment department) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Depatment getDepartment() {
		return department;
	}

	public void setDepartment(Depatment department) {
		this.department = department;
	}

	public List<HouerContract> getContracts() {
		return contracts;
	}

	
	
	public void addContract (HouerContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HouerContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HouerContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValuer();
			}
		}
		return sum;
	}
	
	
	
}
