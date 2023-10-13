package gr.atc.training.exchangerate;

public class RateCalculator {

	private String country;
	private String year;
	private double rate;

	public void RateCalculator() {
		country = " ";
		year = " ";
	}

	public RateCalculator(String year, String country, double rate) {
		this.country = country;
		this.year = year;
		this.rate = rate;
	}

	public RateCalculator() {
		// TODO Auto-generated constructor stub
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
}
