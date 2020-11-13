package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import evaluateur.EvaluateurNiveau;
import exception.ExceptionNoteHorsBorne;
import exception.ExceptionNoteNonEntiere;

class EvaluateurTest {

	@ParameterizedTest(name = "Test limite avec cours={0} et examen={1}. Niveau attendu : {2}")
	@CsvSource({ "0,0,D", "0,29,D", "25,5,C", "25,24,C", "25,25,B", "20,49,B", "20,50,A", "25,75,A" })
	void testLimite(String cours, String examen, String niveauAttendue) throws ExceptionNoteNonEntiere, ExceptionNoteHorsBorne {
		String niveauObtenu = EvaluateurNiveau.evaluerNiveau(cours, examen);
		assertEquals(niveauAttendue, niveauObtenu);
	}

	@ParameterizedTest()
	@CsvSource({ "10.25,20", "xxx,29", "10,20.234", "10,exam" })
	void testExceptionSiValeurNonEntiere(String cours, String examen) {
		assertThrows(ExceptionNoteNonEntiere.class, () -> EvaluateurNiveau.evaluerNiveau(cours, examen));
	}
	
	@ParameterizedTest()
	@CsvSource({ "-1,-1", "26,76"})
	void testExceptionEstDansBorne(String cours, String examen) {
		assertThrows(ExceptionNoteHorsBorne.class, () -> EvaluateurNiveau.evaluerNiveau(cours, examen));
	}

}
