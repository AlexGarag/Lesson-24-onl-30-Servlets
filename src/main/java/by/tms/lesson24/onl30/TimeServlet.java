package by.tms.lesson24.onl30;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.tms.lesson24.onl30.ShaperResponse.shapeResponse;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {
    private static final String DATE_FORMAT = "HH:mm:ss";
    private static final String RESPONSE_TEMPLATE = "time in %s - %s";
    private static final String ERROR_MESSAGE_TEMPLATE = "The city of %s is not processed by the system";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nameCity = req.getParameter("city"); // сделал 2 строчки кода вместо одной для удобства чтения
        String zoneId = switch (nameCity) {
            case "Minsk" -> "Europe/Minsk";
            case "Washington" -> "America/New_York";
            case "Beijing" ->"Asia/Shanghai";
            default -> throw new IllegalStateException(ERROR_MESSAGE_TEMPLATE.formatted(nameCity));
        };
        resp.getWriter().write(RESPONSE_TEMPLATE.formatted(nameCity, shapeResponse(zoneId, DATE_FORMAT)));
    }
}
