package gr.atc.training.exchangerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RateCalculator {

	public void readFile(String path, ArrayList<CountryRate> lista) {
		// mia methodos gia na diavasw to arxeio kai na prostetw
		// antikeimeno sto ArrayList
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

				CountryRate rc = new CountryRate();// dimiourgei ena antikeimeno tou tupou CountryRate
				rc.setCountry(word[1]);// tin xwra pou exei vrei tin vazei mesa sto antikeimeno
				rc.setYear(word[0].split("-")[0]);// tin imerominia pou exei vrei tin vazei mesa sto antikeimeno

				rc.setRate(Double.parseDouble(word[2])); // to pososto pou exei vrei kai to metatrepsei tin vazei mesa
				// sto antikeimeno
				// System.out.println(("I isotimia einai ")+word[2]);
				lista.add(rc); // prostetei to antikeimeno sti lista

			}
			reader.close();// kleinei tin sundesi me to arxeio
		} catch (FileNotFoundException e) {// try catch gia sfalmata
			System.out.println("File not found");
			e.printStackTrace();

		} catch (IOException e) { // try catch gia sfalmata
			e.printStackTrace();
		}

	}

	public CountryRate getCountryRate(String year, String country, ArrayList<CountryRate> lista) {
		for (int i = 0; i < lista.size(); i++) {
			CountryRate r = lista.get(i);
			if (r.getCountry().equals(country) && r.getYear().equals(year))
				return r;
		}
		return null;
	}

}
