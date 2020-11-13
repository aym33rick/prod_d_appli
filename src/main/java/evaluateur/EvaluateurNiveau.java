package evaluateur;

import exception.ExceptionNoteHorsBorne;
import exception.ExceptionNoteNonEntiere;

public class EvaluateurNiveau {
	public static final int LIMITE_D_C = 30;
	public static final int LIMITE_C_B = 50;
	public static final int LIMITE_B_A = 70;

	public static final String NIVEAU_D = "D";
	public static final String NIVEAU_C = "C";
	public static final String NIVEAU_B = "B";
	public static final String NIVEAU_A = "A";
	
	public static final int MIN_COURS = 0;
	public static final int MAX_COURS = 25;
	public static final int MIN_EXAMEN = 0;
	public static final int MAX_EXAMEN = 75;

	public static boolean estEntier(String valeur) {
		try {
			Integer.parseInt(valeur);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean estDansBorne(String valeur, int min, int max) {
		assert min <= max;
		return min <= Integer.parseInt(valeur) && Integer.parseInt(valeur) <= max;
	}

	public static String evaluerNiveau(String cours, String examen)
			throws ExceptionNoteNonEntiere, ExceptionNoteHorsBorne {

		if (!estEntier(cours) || !estEntier(examen)) {
			throw new ExceptionNoteNonEntiere("Cours ou examen n'est pas entier");
		}

		if (!estDansBorne(cours,MIN_COURS,MAX_COURS) || !estDansBorne(examen,MIN_EXAMEN,MAX_EXAMEN)) {
			throw new ExceptionNoteHorsBorne("Cours ou examun est hors borne");
		}

		int icours = Integer.parseInt(cours);
		int iexamen = Integer.parseInt(examen);

		int somme = icours + iexamen;
		String niveau = "";

		if (somme < LIMITE_D_C) {
			niveau = NIVEAU_D;
		} else if (somme < LIMITE_C_B) {
			niveau = NIVEAU_C;
		} else if (somme < LIMITE_B_A) {
			niveau = NIVEAU_B;
		} else {
			niveau = NIVEAU_A;
		}
		return niveau;
	}

}
