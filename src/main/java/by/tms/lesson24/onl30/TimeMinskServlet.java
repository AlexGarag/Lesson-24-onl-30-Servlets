package by.tms.lesson24.onl30;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//Задача 1:
//        Создать приложение, которое при переходе на следующие урлы будет выдавать
//          результат:
//          /minsk - время в Минске
//          /washington - время в Вашингтоне
//          /beijing - время в Пекине

@WebServlet("/minsk")
public class TimeMinskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ZonedDateTime minskDateTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Europe/Minsk"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeString = minskDateTime.format(dateTimeFormatter);
//        resp.setStatus(200);
        resp.getWriter().write("time in Minsk - %s".formatted(timeString));
    }
}
