package fr.starfleet.util;

import java.io.*;

public class FileUtil {

    public static <T> void sauvegarderObjet(T objet, String cheminFichier) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cheminFichier))) {
            oos.writeObject(objet);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T chargerObjet(String cheminFichier) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cheminFichier))) {
            return (T) ois.readObject();
        }
    }
}
