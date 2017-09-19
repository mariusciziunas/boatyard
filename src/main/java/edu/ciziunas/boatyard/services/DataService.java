package edu.ciziunas.boatyard.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.ciziunas.boatyard.entities.City;
import edu.ciziunas.boatyard.entities.Route;
import edu.ciziunas.boatyard.entities.Suburb;

public class DataService {
	
	public static final String DATA_TOKEN = " ";

	/**
	 * Populates data from input file to edu.vinted.boatyard.entities.City object. 
	 * 
	 * @param cityName is the name of current city
	 * @param dataFilePath is the path where input data file is located 
	 * @return populated city object
	 * @throws FileNotFoundException is thrown if input file is not found
	 * @throws IOException if there is a problem while reading data file
	 */
	public static City populateMap(String cityName, String dataFilePath) throws FileNotFoundException, IOException {
		String input = loadMapFromFile(dataFilePath);
		if (!isValid(input)) {
			throw new IllegalArgumentException("Invalid data in input file");
		}
		City city = new City(cityName);
	    String tokens[] = input.split(DATA_TOKEN);
	    
	    for (String token : tokens) {
	    	String startName = token.substring(0, 1);
	    	String endName = token.substring(1, 2);
	    	String routeValue = token.substring(2, 3);
	    	Double routeLength = Double.valueOf(routeValue);
	    	
	    	Suburb end = city.addSuburb(endName);
	    	Route route = new Route(end);
	    	route.setDistance(routeLength);
	    	
	    	Suburb start = city.addSuburb(startName);
	    	start.addRoute(route);
	    }
	    return city;
	}
	
	public static String loadMapFromFile(String dataFilePath) throws FileNotFoundException, IOException {
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(
				dataFilePath))) {
			line = br.readLine();
		}
		return line;
	}
	
	private static boolean isValid(String input) throws IllegalArgumentException {
		return ( input != null && input.matches("([a-zA-Z]{2}\\d{1}\040)*"));
	}
	
}
