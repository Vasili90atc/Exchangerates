package gr.atc.training.exchangerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	static ArrayList<RateCalculator> lista; // einai mia ArrayList pou periexei antikeimena tou CountryRate h opoia
	// onomazetai lista.prosvasimo apo olous stin klasi

	public static void main(String[] args) {
		if (args.length != 1) {
			return;
		}
		String path = args[0];
		System.out.println(path);

		// dilwnw tis metavlites
		String year = null;
		String country = "";
		double rate = 0;
		boolean found = false;

		Scanner input = new Scanner(System.in);// anoigei sundesi apo to pliktrologio

		lista = new ArrayList<>(); // arxikopoioume tin lista
		readFile(path);// kaloume ti methodo gia na diavasoume to arxeio
		System.out.println(" Dwse Date "); // zitame apo to xristi na dwsei hmerominia
		year = input.nextLine(); // tin diavazoume kai tin apothikeuoume
		year.concat("-01-01");
		System.out.println("Dwse Country ");// zitame apo to xristi na dwsei xwra
		country = input.nextLine(); // tin diavazoume kai tin apothikeuoume

		for (int i = 0; i < lista.size(); i++) { // diavazoume to ArrayList
			if (lista.get(i).getYear().equals(year) && lista.get(i).getCountry().equals(country)) { // elegxoume ean h
																									// trexousa
																									// hmeromhnia
				// me tin trexousa xwra einai isa me auta pou exei dwsei o xristis
				found = true; // dilwsi oti vrethike
				System.out.println(lista.get(i).getRate()); // emfanizei to rate pou vrikame
				break;// afou to vrika stamataw ti epanalipsi for
			}

		}
		if (!found) { // elegxei an den to exw vrei
			System.out.println("Not found"); // emfanizw minima oti den to vrika
		}
		input.close(); // kleinei ti sundesi me to pliktrologio

	}

	private static void readFile(String path) { // mia methodos gia na diavasw to arxeio kai na prostetw
												// antikeimeno sto
		// ArrayList
		String line = "";// dilwsi metavlitwn
		BufferedReader reader;// dilwsi eidikou tupou metavlitwn
		System.out.println(path);
		try {
			File f = new File(path);
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));// anoigei to arxeio
			line = reader.readLine();// diavazw tin prwti grammi
			while ((line = reader.readLine()) != null) { // diavazw to arxeio mexri na min exei alles grammes

				String word[] = line.split(",");// spaw se kommatia me vasi to komma pou to exw onomasei word
				if (word.length < 3) { // elegxw an to plithos tou pinaka einai mikrotero apo 3
					continue;// sunexizei me tin epomeni epanalispi
				}

				RateCalculator rc = new RateCalculator();// dimiourgei ena antikeimeno tou tupou CountryRate
				rc.setCountry(word[1]);// tin xwra pou exei vrei tin vazei mesa sto antikeimeno
				rc.setYear(word[0].split("-")[0]);// tin imerominia pou exei vrei tin vazei mesa sto antikeimeno

				rc.setRate(Double.parseDouble(word[2])); // to pososto pou exei vrei kai to metatrepsei tin vazei mesa
				// sto antikeimeno
				// System.out.println(("I isotimia einai ")+word[2]);
				lista.add(rc); // prostetei to antikeimeno sti lista

			}
			reader.close();// kleinei tin sundesi me to arxeio
		} catch (FileNotFoundException e) {// try catch gia sfalmata
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) { // try catch gia sfalmata
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
