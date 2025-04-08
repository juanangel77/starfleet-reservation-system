package fr.starfleet.modele.reservation;

import java.io.Serializable;
import java.util.Date;
import fr.starfleet.modele.personne.Personne;
import fr.starfleet.modele.mission.Mission;

public class Reservation implements Serializable {
    private String idReservation;
    private Personne passager;
    private Mission mission;
    private Date dateReservation;
    private boolean confirmee;

    public Reservation(String idReservation, Personne passager, Mission mission, Date dateReservation) {
        this.idReservation = idReservation;
        this.passager = passager;
        this.mission = mission;
        this.dateReservation = dateReservation;
        this.confirmee = false;
    }

    public String getIdReservation() { return idReservation; }
    public Personne getPassager() { return passager; }
    public Mission getMission() { return mission; }
    public Date getDateReservation() { return dateReservation; }
    public boolean isConfirmee() { return confirmee; }

    public void confirmer() { this.confirmee = true; }
    public void annuler() { this.confirmee = false; }
}