package by.tms.lesson24.onl30;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.tms.lesson24.onl30.ShaperResponse.shapeResponse;

@WebServlet("/washington")
public class WashingtonTimeServlet extends HttpServlet {
    private static final String NAME_CITY = "Washington";
    private static final String ZONE_ID = "America/New_York";
    private static final String DATE_FORMAT = "HH:mm:ss";
    private static final String RESPONSE_TEMPLATE = "time in %s - %s";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write(RESPONSE_TEMPLATE.formatted(NAME_CITY, shapeResponse(ZONE_ID, DATE_FORMAT)));
    }
}
