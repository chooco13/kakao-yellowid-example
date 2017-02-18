package io.chooco13.yellowid.module.heroku;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class KeepAlive {
    private static final Logger logger = LoggerFactory.getLogger(KeepAlive.class);
    private static final int INTERVAL = 5 * 60 * 1000;

    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    // GMT 0 기준
    private static final int SLEEP_TIME = 15;
    private static final int WAKEUP_TIME = SLEEP_TIME + 6;

    @Scheduled(fixedRate = INTERVAL)
    public void ping() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date current = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, SLEEP_TIME);
        Date sleep = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, WAKEUP_TIME);
        Date wakeup = calendar.getTime();

        if (current.before(sleep) || current.after(wakeup)) {
            Runtime runtime = Runtime.getRuntime();

            try {
                Process process = runtime.exec("curl https://io-chooco13-yellowid.herokuapp.com/");
                logger.debug("[curl https://io-chooco13-yellowid.herokuapp.com/]\t" +
                        "process.waitFor()::" + process.waitFor());
            } catch (IOException | InterruptedException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
