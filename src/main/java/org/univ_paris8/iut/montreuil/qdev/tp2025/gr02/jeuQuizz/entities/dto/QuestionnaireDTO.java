package org.univ_paris8.iut.montreuil.qdev.tp2025.gr02.jeuQuizz.entities.dto;

import java.util.List;
import java.util.Objects;

public class QuestionnaireDTO {
    private int id;
    private String nom;
    private String langue;
    private List<QuestionDTO> listeQuestions;
    private float statQuestionnaire; // Nouveau champ ajouté pour la statistique

    public QuestionnaireDTO(int id, String nom, String langue, List<QuestionDTO> listeQuestions) {
        this.id = id;
        this.nom = nom;
        this.langue = langue;
        this.listeQuestions = listeQuestions;
        this.statQuestionnaire = 0.0f; // Initialisation par défaut
    }

    // Getter pour statQuestionnaire
    public float getStatQuestionnaire() {
        return statQuestionnaire;
    }

    // Setter pour statQuestionnaire avec un retour de l'objet courant
    public QuestionnaireDTO setStatQuestionnaire(float statQuestionnaire) {
        this.statQuestionnaire = statQuestionnaire;
        return this; // Retourne l'objet courant pour permettre le chaînage
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public List<QuestionDTO> getListeQuestions() {
        return listeQuestions;
    }

    public void setListeQuestions(List<QuestionDTO> listeQuestions) {
        this.listeQuestions = listeQuestions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionnaireDTO that = (QuestionnaireDTO) o;
        return id == that.id &&
                Float.compare(that.statQuestionnaire, statQuestionnaire) == 0 && // Comparaison de statQuestionnaire
                Objects.equals(nom, that.nom) &&
                Objects.equals(langue, that.langue) &&
                Objects.equals(listeQuestions, that.listeQuestions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, langue, listeQuestions, statQuestionnaire); // Ajout de statQuestionnaire au hashCode
    }

    @Override
    public String toString() {
        return "QuestionnaireDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", langue='" + langue + '\'' +
                ", listeQuestions=" + listeQuestions +
                ", statQuestionnaire=" + statQuestionnaire + // Ajout de statQuestionnaire au toString
                '}';
    }
}
