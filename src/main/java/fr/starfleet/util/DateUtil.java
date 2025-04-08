package fr.starfleet.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static String format(Date date) {
        return sdf.format(date);
    }

    public static Date maintenant() {
        return new Date();
    }
}