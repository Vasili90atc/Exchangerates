package gr.atc.training.exchangerate;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	static ArrayList<CountryRate> lista = new ArrayList<CountryRate>(); // einai mia ArrayList pou periexei antikeimena
																		// tou CountryRate h opoia
	// onomazetai lista.Prosvasimo apo olous stin klasi

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Args number not valid.");
			return;
		}
		String path = args[0];
		System.out.println(path);

		// dilwnw tis metavlites
		String year = null;
		String country = "";

		Scanner input = new Scanner(System.in);// anoigei sundesi apo to pliktrologio
		// arxikopoioume tin lista
		RateCalculator u = new RateCalculator();
		u.readFile(path, lista); // kaloume ti methodo gia na diavasoume to arxeio
		System.out.println(" Dwse Date "); // zitame apo to xristi na dwsei hmerominia
		year = input.nextLine(); // tin diavazoume kai tin apothikeuoume
		year.concat("-01-01");
		System.out.println("Dwse Country ");// zitame apo to xristi na dwsei xwra
		country = input.nextLine(); // tin diavazoume kai tin apothikeuoume
		input.close(); // kleinei ti sundesi me to pliktrologio

		CountryRate wantedRate = u.getCountryRate(year, country, lista);
		if (wantedRate == null) {
			System.out.println("Not found"); // emfanizw minima oti den to vrika
		} else {
			System.out.println("Rate: " + wantedRate.getRate());
		}
	}
}
