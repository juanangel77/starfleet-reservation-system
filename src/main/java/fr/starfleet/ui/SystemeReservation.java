package fr.starfleet.ui;

import fr.starfleet.modele.mission.Mission;
import fr.starfleet.modele.personne.Personne;
import fr.starfleet.modele.reservation.Reservation;
import fr.starfleet.util.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SystemeReservation {
    private List<Mission> missions;

    public SystemeReservation() {
        this.missions = new ArrayList<>();
    }

    public void ajouterMission(Mission mission) {
        missions.add(mission);
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public boolean reserverPlace(Personne personne, String codeMission) {
        for (Mission m : missions) {
            if (m.getCode().equalsIgnoreCase(codeMission)) {
                String idReservation = UUID.randomUUID().toString();
                Reservation r = new Reservation(idReservation, personne, m, DateUtil.maintenant());
                return m.ajouterReservation(r);
            }
        }
        return false;
    }
}
