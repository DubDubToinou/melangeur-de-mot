package fr.eni.melangeurdemots;

import java.util.Random;
import java.util.Scanner;

public class MelangeurDeMots2 {
	
	private static String melangeMot(String mot)
	{
		String motMelange = "";
		Random random = new Random();
		
		if(mot.length() <= 2) motMelange = mot;
		else
		{
			String milieuMot = mot.substring(1, mot.length()-1);

			while(milieuMot.length() >= 2)
			{
				
				int valeurAlea = 1 + random.nextInt(milieuMot.length() -1);
				motMelange += milieuMot.charAt(valeurAlea);
				milieuMot = milieuMot.substring(0, valeurAlea) + milieuMot.substring(valeurAlea+1);
			}
			
			motMelange = mot.substring(0, 1) + motMelange + milieuMot + mot.substring(mot.length() - 1);
		}

		return motMelange;
	}
	
	public static void main(String[] args) {
		
		System.out.println("merci de saisir une phrase : ");
		String phrase = SaisirLine();
		String[] mot = phrase.split(" ");
		String totalMotMelange = "";
		
		for(int i = 0 ; i < mot.length ;i++)
		{
			if(i >= 0)
			{
				totalMotMelange += " ";
				totalMotMelange += melangeMot(mot[i]);
			}
		}
		System.out.println("la phrase est : " +totalMotMelange);

	}

	public static String SaisirLine()
	{
		Scanner scan = new Scanner(System.in);
		String result = scan.nextLine();
		return result;
	}

}
