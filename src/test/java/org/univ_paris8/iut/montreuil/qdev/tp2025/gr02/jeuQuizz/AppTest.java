package org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.services.interfaces.IQuestionnaireServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.utils.exceptions.ChargementFichierException;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    IQuestionnaireServices questionnaireServices;

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void questionnaireOKTest(){
        List<QuestionnaireDTO> listQuestionnaireAttendu = new ArrayList<>();
        QuestionDTO questionDTOAttendu = new QuestionDTO(1, 3, "fr", "Combien y a-t-il de joueurs sur le terrain dans une équipe de football ?", "Onze", 1, "Codifié par les Britanniques à la fin du XIXe siècle, le football s'est doté en 1904 d'une fédération internationale, la FIFA.", "https://fr.wikipedia.org/wiki/Football");
        List<QuestionDTO> listQuestion = new ArrayList<>();
        listQuestion.add(questionDTOAttendu);
        QuestionnaireDTO questionnaireDTOAttendu = new QuestionnaireDTO(1, "Questionnaire", "fr", listQuestion);

        List<QuestionnaireDTO> resultListQuestionnaireDTO;
        questionnaireServices = new FournirListeQuestionnaireOKBouchon();
        try {
            resultListQuestionnaireDTO = questionnaireServices.fournirListeQuestionnaires("src/test/resources/FichierOK.csv");
        }
        catch (ChargementFichierException e){
            e.printStackTrace();
        }
    }
}


