package org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.utils.exceptions.ChargementFichierException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.utils.exceptions.FichierCorrompuException;

import java.io.IOException;
import java.util.List;

public interface IQuestionnaireServices {

    public List<QuestionnaireDTO> fournirListeQuestionnaires(String path) throws ChargementFichierException;

}
