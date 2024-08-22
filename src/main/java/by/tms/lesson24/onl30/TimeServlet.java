package by.tms.lesson24.onl30;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String city = req.getParameter("city");
        ZonedDateTime now = null;
        switch (city) {
            case "Minsk":
                now = ZonedDateTime.now(ZoneId.of("Europe/Minsk"));
                break;
            case "Washington":
                now = ZonedDateTime.now(ZoneId.of("America/New_York"));
                break;
            case "Beijing":
                now = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
                break;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString = now.format(dateTimeFormatter);
        resp.getWriter().write("time in %s - %s".formatted(city, timeString));
    }
}
