package by.lobanov.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class MyUtil {

    public static void sleep (Long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            log.error("interrupted exception {}", e.getMessage());
        }
    }
}
