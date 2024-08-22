package by.tms.lesson24.onl30;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/beijing")
public class BeijingTimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ZonedDateTime minskDateTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString = minskDateTime.format(dateTimeFormatter);
        resp.getWriter().write("time in Beijing - %s".formatted(timeString));
    }
}
