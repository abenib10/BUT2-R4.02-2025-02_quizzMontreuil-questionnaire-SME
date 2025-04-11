package org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz;

import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.utils.exceptions.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionnaireServicesExtendedTest {

    private IQuestionnaireServices service;

    @Test
    void testChargerQuestionnaireValide() throws ChargementFichierException {
        service = new FournirListeQuestionnaireOKBouchon();

        List<QuestionnaireDTO> questionnaires = service.fournirListeQuestionnaires("src/test/resources/questionsOK.csv");

        assertNotNull(questionnaires, "La liste des questionnaires ne doit pas être nulle");
        assertFalse(questionnaires.isEmpty(), "La liste des questionnaires ne doit pas être vide");

        QuestionnaireDTO questionnaire = questionnaires.get(0);

        assertEquals("Culture générale", questionnaire.getNom(), "Le nom du questionnaire doit être 'Culture générale'");
        assertEquals(1, questionnaire.getListeQuestions().size(), "Le questionnaire doit contenir une seule question");

        QuestionDTO question = questionnaire.getListeQuestions().get(0);
        assertEquals("Quelle est la capitale de la France ?", question.getLibelle(), "La question doit correspondre à celle attendue");
        assertEquals("Paris", question.getReponse(), "La réponse doit être 'Paris'");
    }

    @Test
    void testChargerQuestionnaireVide() {
        service = new QuestionnaireServiceImplVideBouchon();

        assertThrows(FichierVideException.class, () -> {
            service.fournirListeQuestionnaires("src/test/resources/questionVide.csv");
        }, "Une exception FichierVideException aurait dû être levée");
    }

    @Test
    void testFichierCorrompu() {
        service = new QuestionnaireServiceImplCorrompuBouchon();

        assertThrows(FichierCorrompuException.class, () -> {
            service.fournirListeQuestionnaires("src/test/resources/fichierCorrompu.csv");
        }, "Une exception FichierCorrompuException aurait dû être levée");
    }
}
