package org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.utils.exceptions.ChargementFichierException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FournirListeQuestionnaireOKBouchon implements IQuestionnaireServices {
    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String path) throws ChargementFichierException {
        List<QuestionDTO> questions = new ArrayList<>();
        questions.add(new QuestionDTO(1, 1, "fr", "Quelle est la capitale de la France ?", "Paris", 1, "La capitale est Paris.", "Source officielle"));

        QuestionnaireDTO questionnaire = new QuestionnaireDTO(1, "Culture générale", "fr", questions)
                .setStatQuestionnaire(85.5f);

        System.out.println("Statistique du questionnaire : " + questionnaire.getStatQuestionnaire());

        List<QuestionnaireDTO> listeQuestionnaires = new ArrayList<>();
        listeQuestionnaires.add(questionnaire);

        return listeQuestionnaires;
    }
}
