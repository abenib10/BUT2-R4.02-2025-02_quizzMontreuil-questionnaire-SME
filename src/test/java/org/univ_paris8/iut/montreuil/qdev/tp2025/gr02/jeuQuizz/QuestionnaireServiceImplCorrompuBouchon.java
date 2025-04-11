package org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.utils.exceptions.ChargementFichierException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.utils.exceptions.FichierCorrompuException;

import java.util.List;

public class QuestionnaireServiceImplCorrompuBouchon implements IQuestionnaireServices {
    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String path) throws ChargementFichierException {
        throw new FichierCorrompuException();
    }
}
