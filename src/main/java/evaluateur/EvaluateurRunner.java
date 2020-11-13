package evaluateur;

import exception.ExceptionNoteHorsBorne;
import exception.ExceptionNoteNonEntiere;

public class EvaluateurRunner {
	
	public static void main(String[] args) {
		
		int nbArgs = args.length;
		
		if(nbArgs == 2) {
			String cours = args[0];
			String exam = args[1];
			try {
				String niveau = EvaluateurNiveau.evaluerNiveau(cours, exam);
				System.out.println("Niveau etudiant : " + niveau);
			} catch (ExceptionNoteHorsBorne ehb) {
				System.out.println("Note(s) hors bonres !");
			} catch (ExceptionNoteNonEntiere evne) {
				System.out.println("Note(s) non entiere !");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("2 arguments attendus : cours examen");
		}
		
	}
	
}
