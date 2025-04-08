package fr.starfleet;

import fr.starfleet.modele.personne.*;
import fr.starfleet.modele.vaisseau.*;
import fr.starfleet.modele.mission.*;
import fr.starfleet.modele.reservation.*;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Mission> missions = new ArrayList<>();
    private static final List<Vaisseau> vaisseaux = new ArrayList<>();
    private static final List<Personne> personnes = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Starfleet Reservation System ===");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Créer un vaisseau");
            System.out.println("2. Créer une mission");
            System.out.println("3. Ajouter une personne");
            System.out.println("4. Créer une réservation");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // consomme le retour à la ligne

            switch (choix) {
                case 1 -> creerVaisseau();
                case 2 -> creerMission();
                case 3 -> ajouterPersonne();
                case 4 -> creerReservation();
                case 5 -> {
                    System.out.println("Fin du programme.");
                    return;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }

    private static void creerVaisseau() {
        System.out.print("Nom du vaisseau : ");
        String nom = scanner.nextLine();
        System.out.print("Immatriculation : ");
        String immatriculation = scanner.nextLine();
        System.out.print("Capacité maximale : ");
        int capacite = scanner.nextInt();
        scanner.nextLine();

        Vaisseau vaisseau = new Vaisseau(nom, immatriculation, capacite);
        vaisseaux.add(vaisseau);
        System.out.println("Vaisseau ajouté !");
    }

    private static void creerMission() {
        if (vaisseaux.isEmpty()) {
            System.out.println("Aucun vaisseau disponible. Créez-en un d'abord.");
            return;
        }

        System.out.print("Code de la mission : ");
        String code = scanner.nextLine();
        System.out.print("Description : ");
        String description = scanner.nextLine();
        System.out.print("Destination : ");
        String destination = scanner.nextLine();
        Date maintenant = new Date();

        System.out.println("Choisissez un vaisseau :");
        for (int i = 0; i < vaisseaux.size(); i++) {
            System.out.println(i + ": " + vaisseaux.get(i).getNom());
        }
        int choixVaisseau = scanner.nextInt();
        scanner.nextLine();

        Vaisseau vaisseau = vaisseaux.get(choixVaisseau);
        Mission mission = new Mission(code, description, maintenant, maintenant, destination, vaisseau);
        vaisseau.ajouterMission(mission);
        missions.add(mission);
        System.out.println("Mission créée.");
    }

    private static void ajouterPersonne() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Identifiant : ");
        String id = scanner.nextLine();

        System.out.println("Type de personne ? (1 = Officier, 2 = Civil)");
        int type = scanner.nextInt();
        scanner.nextLine();

        Personne personne;
        if (type == 1) {
            System.out.print("Rang : ");
            String rang = scanner.nextLine();
            System.out.print("Spécialité : ");
            String specialite = scanner.nextLine();
            personne = new Officier(nom, prenom, id, rang, specialite);
        } else {
            System.out.print("Planète d'origine : ");
            String planete = scanner.nextLine();
            System.out.print("Motif du voyage : ");
            String motif = scanner.nextLine();
            personne = new Civil(nom, prenom, id, planete, motif);
        }

        personnes.add(personne);
        System.out.println("Personne ajoutée.");
    }

    private static void creerReservation() {
        if (missions.isEmpty() || personnes.isEmpty()) {
            System.out.println("Ajoutez d'abord une mission et une personne.");
            return;
        }

        System.out.println("Choisissez une personne :");
        for (int i = 0; i < personnes.size(); i++) {
            System.out.println(i + ": " + personnes.get(i).getDescription());
        }
        int indexPersonne = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Choisissez une mission :");
        for (int i = 0; i < missions.size(); i++) {
            System.out.println(i + ": " + missions.get(i).getReservations().size() + " réservations - " +
                    missions.get(i).getNombrePlacesDisponibles() + " places disponibles");
        }
        int indexMission = scanner.nextInt();
        scanner.nextLine();

        String idReservation = "RES" + new Random().nextInt(10000);
        Date dateRes = new Date();
        Reservation reservation = new Reservation(idReservation, personnes.get(indexPersonne), missions.get(indexMission), dateRes);

        boolean ajoutOK = missions.get(indexMission).ajouterReservation(reservation);
        if (ajoutOK) {
            System.out.println("Réservation créée avec l'ID : " + idReservation);
        } else {
            System.out.println("Échec : pas de place disponible.");
        }
    }
}
