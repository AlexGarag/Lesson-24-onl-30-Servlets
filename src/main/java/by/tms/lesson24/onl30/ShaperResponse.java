package by.tms.lesson24.onl30;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ShaperResponse {

    public static String shapeResponse(String ZoneId, String dateFormat) {
        ZonedDateTime dateTime = ZonedDateTime.now().withZoneSameInstant(java.time.ZoneId.of(ZoneId));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        return dateTime.format(dateTimeFormatter);
    }
}
