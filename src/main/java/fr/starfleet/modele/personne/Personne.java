package fr.starfleet.modele.personne;

import java.io.Serializable;

public abstract class Personne implements Serializable {
    private String nom;
    private String prenom;
    private String identifiant;

    public Personne(String nom, String prenom, String identifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getIdentifiant() { return identifiant; }
    public void setIdentifiant(String identifiant) { this.identifiant = identifiant; }

    public abstract String getDescription();
}