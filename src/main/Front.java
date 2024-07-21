package main;

import objects.Persona;
import tools.*;

public class Front {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main parse = new Main();
		Persona personaByArcanaRank = parse.getPersonaByArcanaRank("Fool", 1);
		Persona personaByName = parse.getPersonaByName("Arsene");

		System.out.printf("[%s - %d] %s [%d]\n", personaByArcanaRank.getArcana(), personaByArcanaRank.getRank(), personaByArcanaRank.getName(), personaByArcanaRank.getLevel());		
		System.out.printf("[%s - %d] %s [%d]\n", personaByName.getArcana(), personaByName.getRank(), personaByName.getName(), personaByName.getLevel());		
		
		FusionChart fc = new FusionChart();
//		for (int i = 0; i < 23; i++) {
//			System.out.println(fc.getFusionArcana(i, i));
//		}
//		System.out.println(fc.getFusionArcana(0, 1));
	}

}
