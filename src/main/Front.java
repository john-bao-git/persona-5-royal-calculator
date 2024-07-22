package main;

import objects.Persona;
import tools.*;

public class Front {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main parse = new Main();
//		Persona personaByArcanaRank = parse.getPersonaByArcanaRank("Fool", 1);
//		Persona personaByName = parse.getPersonaByName("Arsene");
//		Persona personaByArcanaLevel = parse.getPersonaByArcanaLevel("Magician", 50, true);
//		System.out.println(personaByArcanaLevel.toString());
//		System.out.println("---");
//		personaByArcanaLevel = parse.getPersonaByArcanaLevel("Magician", 50, false);
//		System.out.println(personaByArcanaLevel.toString());
		
		Persona resPersona = parse.fusion("Arsene", "Jack-o'-Lantern"); // Should lead to Mokoi
		System.out.println(resPersona.toString());

//		System.out.printf("[%s - %d] %s [%d]\n", personaByArcanaRank.getArcana(), personaByArcanaRank.getRank(), personaByArcanaRank.getName(), personaByArcanaRank.getLevel());		
//		System.out.printf("[%s - %d] %s [%d]\n", personaByName.getArcana(), personaByName.getRank(), personaByName.getName(), personaByName.getLevel());		

		
//		FusionChart fc = new FusionChart();

//		for (int i = 0; i < 23; i++) {
//			System.out.println(fc.getFusionArcana(i, i));
//		}
//		System.out.println(fc.getFusionArcana(0, 1));
	}

}
