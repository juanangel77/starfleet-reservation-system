package fr.starfleet.modele.personne;

public class Officier extends Personne {
    private String rang;
    private String specialite;

    public Officier(String nom, String prenom, String identifiant, String rang, String specialite) {
        super(nom, prenom, identifiant);
        this.rang = rang;
        this.specialite = specialite;
    }

    public String getRang() { return rang; }
    public void setRang(String rang) { this.rang = rang; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    @Override
    public String getDescription() {
        return "Officier " + getPrenom() + " " + getNom() + ", Rang: " + rang + ", Spécialité: " + specialite;
    }
}