package fr.starfleet.modele.vaisseau;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import fr.starfleet.modele.mission.Mission;

public class Vaisseau implements Serializable {
    private String nom;
    private String immatriculation;
    private int capaciteMaximale;
    private List<Mission> missions = new ArrayList<>();

    public Vaisseau(String nom, String immatriculation, int capaciteMaximale) {
        this.nom = nom;
        this.immatriculation = immatriculation;
        this.capaciteMaximale = capaciteMaximale;
    }

    public String getNom() { return nom; }
    public String getImmatriculation() { return immatriculation; }
    public int getCapaciteMaximale() { return capaciteMaximale; }
    public List<Mission> getMissions() { return missions; }

    public void ajouterMission(Mission mission) {
        this.missions.add(mission);
    }
}