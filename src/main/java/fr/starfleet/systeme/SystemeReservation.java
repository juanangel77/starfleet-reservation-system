package fr.starfleet.systeme;

import fr.starfleet.modele.personne.*;
import fr.starfleet.modele.mission.*;
import fr.starfleet.modele.reservation.*;
import fr.starfleet.util.*;

import java.util.*;

public class SystemeReservation {
    private List<Mission> missions = new ArrayList<>();

    public void ajouterMission(Mission mission) {
        missions.add(mission);
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public Mission trouverMissionParCode(String code) {
        for (Mission m : missions) {
            if (m.getCode().equalsIgnoreCase(code)) {
                return m;
            }
        }
        return null;
    }

    public boolean reserverPlace(Personne personne, String codeMission) {
        Mission mission = trouverMissionParCode(codeMission);
        if (mission != null) {
            Reservation r = new Reservation(UUID.randomUUID().toString(), personne, mission, DateUtil.maintenant());
            return mission.ajouterReservation(r);
        }
        return false;
    }
}