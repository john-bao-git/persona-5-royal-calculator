package main;

import objects.Persona;
import tools.*;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
	private JSONObject jsonArcana;
	private JSONObject jsonPersona;
	private FusionChart fc;
	
	public Main() {
		init();
	}
	
	private void init() {
		JSONParser parser = new JSONParser();
		
		String filePath = new File("").getAbsolutePath();
		
		try {
			// Get the full thing
			jsonArcana = (JSONObject) parser.parse(new FileReader(filePath + "/src/tools/arcana.json"));
			jsonPersona = (JSONObject) parser.parse(new FileReader(filePath + "/src/tools/persona.json"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		fc = new FusionChart();
	}
	
	public Persona getPersonaByArcanaRank(String arcana, Integer i) {	
		String name = "", type = "";
		Integer level = 1, rank = 1;
		
		try {			
			// Get specifically the Arcana, which is an array
			JSONArray personaList = (JSONArray) jsonArcana.get(arcana);
			JSONObject persona = (JSONObject) personaList.get(i - 1);
			
			name = (String) persona.get("name");
			type = (String) persona.get("type");
			level = Math.toIntExact((Long) persona.get("level"));
			rank = Math.toIntExact((Long) persona.get("rank"));	
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid Index by Arcana Rank");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Invalid Arcana by Arcana Rank");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Persona(name, arcana, type, level, rank);
	}
	
	public Persona getPersonaByName(String name) {
		String arcana = "", type = "";
		Integer level = 1, rank = 1;
		
		try {			
			// Get specifically the Arcana, which is an array
			JSONObject persona = (JSONObject) jsonPersona.get(name);
			
			arcana = (String) persona.get("arcana");
			type = (String) persona.get("type");
			level = Math.toIntExact((Long) persona.get("level"));
			rank = Math.toIntExact((Long) persona.get("rank"));	
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid Index by Name");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Invalid Arcana by Name");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Persona(name, arcana, type, level, rank);
	}
	
	public Persona fusion(String p1, String p2) {
		Persona res = new Persona("Name", "Persona", "Type", 1, 1);
		
		/*
		 * Use the Arcana Tables
		 * 
		 * Base Level = avg of the base levels rounded up
		 * 
		 * Result:
		 * 	If Different Arcana, Persona with the next highest base level of the calculated base level
		 * 	If Same Arcana, Persona with the next lowest base level
		 */
		
		Persona persona1 = getPersonaByName(p1);
		Persona persona2 = getPersonaByName(p2);
		
		String resArcana = fc.getFusionArcana(persona1.getArcana(), persona2.getArcana());
		
		return res;
	}
}
