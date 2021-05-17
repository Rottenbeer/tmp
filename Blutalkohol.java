package Blutalkohol;

import java.util.Scanner;
public class Blutalkohol {

	public static double rundenZweiteNachkommastelle(double zahl)
		
		{
			return Math.round(zahl * 100) / 100.0;
		}
		
		public static void main(String[] args) 
		{
			System.out.println("***BLUTALKOHOL-RECHNER***");
			
			Scanner sc = new Scanner(System.in);
			
		//AUSWAHL Mann/Frau/Kind:
			
			// r: Verteilungsfaktor im Körper
			System.out.println("Bist du ein Mann, eine Frau oder ein Kind?");
			
			double verteilFaktImKörper = 0;
			
			while (verteilFaktImKörper == 0) 
			{
				String koerper = sc.next();
				
				switch (koerper)
				{
					case "Mann" : verteilFaktImKörper = 0.7; // Männer: r ≈ 0,7
					break;
					case "Frau" : verteilFaktImKörper = 0.6; // Frauen: r ≈ 0,6
					break;
					case "Kind" : verteilFaktImKörper = 0.8; // Kinder: r ≈ 0,8
					break;
					default: System.out.println("FEHLER! Tippe Mann, Frau oder Kind");
					break; 
				}
			}
			
		//KONSTANTEN:
			
			// ρ: Dichte von Alkohol [g/ml]→ρ ≈ 0,8 g/ml
			double dichteAlk = 0.8;
			
		//BENUTZER EINAGBEN
			
			// m: Masse der Person in [kg]
			System.out.println("Wie viel wiegst du in Kilogram?");
			double koerperGewicht = sc.nextDouble(); 
			
			// ϵ: Alkoholvolumenanteil in [%] (z.B. Bier ≈ 0,05)
			System.out.println("Wie viel Alkoholvolumenanteil in % hatte das Getrunkene Getränk?");
			double alkVolAnteil = sc.nextDouble();
			
			// V: Volumen des Getränks in [ml]
			System.out.println("Wie viel von dem genannten Getränk hast du getrunken in Milliliter?");
			double volDesGetränks = sc.nextDouble();
			
		//RECHNUNGEN:
			
			// A: AufgenommeneMasse des Alkohols in [g]
			// A = V∗ϵ∗ρ
			double aufgeMasseAlk = volDesGetränks * alkVolAnteil * dichteAlk;
			
			// c: Alkoholkonzentration im Blut in [g/kg]
			// c = A/(m∗r)
			double alkKonzImBlut = aufgeMasseAlk / ( koerperGewicht * verteilFaktImKörper);
			
		//ERGEBNIS:
			System.out.println("Du hast ungefähr " + rundenZweiteNachkommastelle(alkKonzImBlut) + " Promille");
			
			sc.close();
		}
	}
