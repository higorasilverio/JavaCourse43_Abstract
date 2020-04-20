package entities;

public class Company extends TaxPayer{
	
	private Integer numberOfEmployees;
	
	public Company(String name, Double anualIncome) {
		super(name, anualIncome);
	}
	
	public Company(String name, Double anualIncome, Integer numberOfEmployess) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployess;
	}
	
	public Integer getNumberOfEmployess() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployess(Integer numberOfEmployess) {
		this.numberOfEmployees = numberOfEmployess;
	}

	@Override
	public Double tax() {
		if (numberOfEmployees > 10) return  super.getAnualIncome() * 0.14;
		else return super.getAnualIncome() * 0.16;
	}
	
	@Override
	public String toString() {
		return super.getName() + ": $ " + String.format("%.2f", tax()); 
	}
}
