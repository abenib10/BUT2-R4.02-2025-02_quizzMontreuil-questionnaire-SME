package org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.utils.exceptions.ChargementFichierException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.utils.exceptions.FichierCorrompuException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionnaireServicesImpl implements IQuestionnaireServices {
    private static QuestionnaireServicesImpl instance;

    private final List<QuestionnaireDTO> listeQuestionnaire;

    private QuestionnaireServicesImpl() {
        this.listeQuestionnaire = new ArrayList<>();
    }

    public static QuestionnaireServicesImpl getInstance() {
        if (instance == null) {
            instance = new QuestionnaireServicesImpl();
        }
        return instance;
    }
    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String path) throws ChargementFichierException {
        if (!listeQuestionnaire.isEmpty()) {
            return listeQuestionnaire;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String ligne;

            while ((ligne = br.readLine()) != null) {
                String[] elements = ligne.split(";");
                if (elements.length != 8) {
                    throw new FichierCorrompuException();
                }

                String question = elements[3].trim();
                String reponse = elements[4].trim();
                String libelle = elements[0].trim();
                float stat;

                try {
                    stat = Float.parseFloat(elements[5].trim());
                } catch (NumberFormatException e) {
                    throw new ChargementFichierException();
                }

                QuestionDTO questionDTO = new QuestionDTO(
                        1,                  // idQuestionnaire
                        1,                  // numQuestion
                        "fr",               // langue
                        "Question de golf", // libelle (texte de la question)
                        "Tee",              // reponse
                        2,                  // difficulte (1-5)
                        "Explication...",   // explication
                        "Source officielle" // reference
                );

                List<QuestionDTO> listeQuestions = new ArrayList<>();
                listeQuestions.add(questionDTO);

                QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO(
                        1,                  // id
                        "Général",          // nom
                        "fr",               // langue
                        listeQuestions
                );

                List<QuestionnaireDTO> listeQuestionnaire = new ArrayList<>();
                listeQuestionnaire.add(questionnaireDTO);


            }

        } catch (IOException e) {
            throw new ChargementFichierException();
        }

        return listeQuestionnaire;
    }
}

