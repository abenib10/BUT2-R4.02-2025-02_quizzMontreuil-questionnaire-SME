package org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.entities.dto;

import java.util.Objects;
public class QuestionDTO {
    private int idQuestionnaire;
    private int numQuestion;
    private String langue;
    private String libelle;
    private String reponse;
    private int difficulte;
    private String explication;
    private String reference;

    public QuestionDTO(int idQuestionnaire, int numQuestion, String langue, String libelle, String reponse, int difficulte, String explication, String reference) {
        this.idQuestionnaire = idQuestionnaire;
        this.numQuestion = numQuestion;
        this.langue = langue;
        this.libelle = libelle;
        this.reponse = reponse;
        this.difficulte = difficulte;
        this.explication = explication;
        this.reference = reference;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public int getNumQuestion() {
        return numQuestion;
    }

    public void setNumQuestion(int numQuestion) {
        this.numQuestion = numQuestion;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public String getExplication() {
        return explication;
    }

    public void setExplication(String explication) {
        this.explication = explication;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDTO that = (QuestionDTO) o;
        return idQuestionnaire == that.idQuestionnaire &&
                numQuestion == that.numQuestion &&
                difficulte == that.difficulte &&
                Objects.equals(langue, that.langue) &&
                Objects.equals(libelle, that.libelle) &&
                Objects.equals(reponse, that.reponse) &&
                Objects.equals(explication, that.explication) &&
                Objects.equals(reference, that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestionnaire, numQuestion, langue, libelle, reponse, difficulte, explication, reference);
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "idQuestionnaire=" + idQuestionnaire +
                ", numQuestion=" + numQuestion +
                ", langue='" + langue + '\'' +
                ", libelle='" + libelle + '\'' +
                ", reponse='" + reponse + '\'' +
                ", difficulte=" + difficulte +
                ", explication='" + explication + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }

}
