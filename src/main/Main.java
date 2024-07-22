package main;

import objects.Persona;
import tools.*;

import java.io.File;
import java.io.FileReader;
import java.util.List;

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
	
	public Persona getPersonaByArcanaLevel(String arcana, Integer level, Boolean sameArcana) {	
		String name = "", type = "";
		Integer rank = 1;
		
		try {			
			// Get specifically the Arcana, which is an array
			JSONArray personaArray = (JSONArray) jsonArcana.get(arcana);
			JSONObject persona = searchThroughPersonaList(personaArray, level, sameArcana);
			
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
	
	private JSONObject searchThroughPersonaList(JSONArray personaArray, Integer level, Boolean sameArcana) {
		int i = (sameArcana)
			? i = personaArray.size() - 1
			: 0;
		JSONObject persona = (JSONObject) personaArray.get(i);
		JSONObject lastNormalPersona = persona;
		
		if (sameArcana) {			
			while (level < Math.toIntExact((Long) persona.get("level")) && -1 < i) {
				persona = (JSONObject) personaArray.get(i);
				
				if (((String) persona.get("type")).equals("normal")) {
					lastNormalPersona = persona;
					
					if (Math.toIntExact((Long) persona.get("level")) == level) {
						return lastNormalPersona;
					}
				}
				
				i--;
			}
		} else {
			while (Math.toIntExact((Long) persona.get("level")) < level && i < (personaArray.size())) {		
				persona = (JSONObject) personaArray.get(i);	
				
				if (((String) persona.get("type")).equals("normal")) {
					lastNormalPersona = persona;
					
					if (Math.toIntExact((Long) persona.get("level")) == level) {
						return lastNormalPersona;
					}
				}
				
				i++;
			}
		}
		
		return lastNormalPersona;
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
		Persona persona1 = getPersonaByName(p1);
		Persona persona2 = getPersonaByName(p2);
				
		if (persona1.getType().equals("normal") && persona2.getType().equals("normal")) {
			return fusionNormal(persona1, persona2);
		}
		
		return fusionNormal(persona1, persona2);
	}
	
	public Persona fusionNormal(Persona p1, Persona p2) {		
		/*
		 * Use the Arcana Tables
		 * 
		 * Base Level = avg of the base levels rounded up
		 * 
		 * Result:
		 * 	If Different Arcana, Persona with the next highest base level of the calculated base level
		 * 	If Same Arcana, Persona with the next lowest base level
		 */
		
		String resArcana = fc.getFusionArcana(p1.getArcana(), p2.getArcana());
		Integer resLevel = ((p1.getLevel() + p2.getLevel()) / 2) + 1;
		
		// Figure out the direction to go in the arcana list
		// True means it goes down, False goes up
		Boolean sameArcana = (p1.getArcana() == p2.getArcana());
		
		Persona res = getPersonaByArcanaLevel(resArcana, resLevel, sameArcana);
		
		return res;
	}
}
