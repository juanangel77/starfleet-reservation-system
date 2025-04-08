package fr.starfleet.modele.mission;

import java.io.Serializable;
import java.util.*;
import fr.starfleet.modele.vaisseau.Vaisseau;
import fr.starfleet.modele.reservation.Reservation;

public class Mission implements Serializable {
    private String code;
    private String description;
    private Date dateDepart;
    private Date dateRetour;
    private String destination;
    private Vaisseau vaisseau;
    private List<Reservation> reservations = new ArrayList<>();
    private int capaciteMaximale;

    public Mission(String code, String description, Date dateDepart, Date dateRetour, String destination, Vaisseau vaisseau) {
        this.code = code;
        this.description = description;
        this.dateDepart = dateDepart;
        this.dateRetour = dateRetour;
        this.destination = destination;
        this.vaisseau = vaisseau;
        this.capaciteMaximale = vaisseau.getCapaciteMaximale();
    }

    public boolean ajouterReservation(Reservation reservation) {
        if (getNombrePlacesDisponibles() > 0) {
            reservations.add(reservation);
            return true;
        }
        return false;
    }

    public boolean annulerReservation(String idReservation) {
        return reservations.removeIf(r -> r.getIdReservation().equals(idReservation));
    }

    public int getNombrePlacesDisponibles() {
        return capaciteMaximale - reservations.size();
    }

    public List<Reservation> getReservations() { return reservations; }
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public Date getDateDepart() { return dateDepart; }
    public Date getDateRetour() { return dateRetour; }
    public String getDestination() { return destination; }
    public Vaisseau getVaisseau() { return vaisseau; }
}