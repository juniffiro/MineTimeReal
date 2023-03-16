package ua.juniffiro.ms.timereal.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 13/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class TimeUtil {

    /**
     * Parse ZoneId by timeZone.
     *
     * @param timeZone
     *        Region time zone
     *
     * @return {@link java.time.ZoneId}
     */
    public static ZoneId getTimeZone(String timeZone) {
        ZoneId zoneId = null;
        try {
            zoneId = ZoneId.of(timeZone);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return zoneId;
    }

    public static int getTime(ZoneId zoneId) {
        ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.now(), zoneId);
        int hours = (zdt.getHour() * 1000) - 6000;
        int minutes = (zdt.getMinute() * 10) - 60;
        return hours + minutes;
    }
}
