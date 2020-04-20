package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<TaxPayer> list = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of tax payers: ");
		int number = input.nextInt();
		for (int control = 1; control <= number; control ++) {
			System.out.println("Tax payer #" + control + " data:");
			System.out.print("Individual or company (i/c)? ");
			input.nextLine();
			char decision = input.nextLine().charAt(0);
			System.out.print("Name: ");
			String name = input.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = input.nextDouble();
			if (decision == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = input.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else if (decision == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = input.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
			else System.out.println("Individual or company feature was not selected correctly!");
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		double sum = 0.0;
		for (TaxPayer obj : list) {
			System.out.println(obj);
			sum += obj.tax();
		}
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f", sum);
		input.close();
		
	}

}
