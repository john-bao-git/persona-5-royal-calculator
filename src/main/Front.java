package main;

import objects.Persona;
import tools.*;

public class Front {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main parse = new Main();

		// For now, assume correctly spelled names
		// We will want to use a dropdown with the spellings correct
		Persona resPersona = parse.fusion("Satanael", "Satanael");
		System.out.println(resPersona.toString());
	}
}
