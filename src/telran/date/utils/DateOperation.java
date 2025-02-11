package telran.date.utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;

public class DateOperation {

    public static int getAge(String birthDate) {
        DateTimeFormatter formatter = birthDate.contains("/")
                ? DateTimeFormatter.ofPattern("dd/MM/yyyy")
                : DateTimeFormatter.ISO_LOCAL_DATE;

        LocalDate date = LocalDate.parse(birthDate, formatter);
        return (int) ChronoUnit.YEARS.between(date, LocalDate.now());
    }


    public static String[] sortStringDates(String[] dates) {
        Arrays.sort(dates, Comparator.comparing((String date) -> {
            try {
                return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            } catch (Exception e) {
                return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        }));
        return dates;
    }
};
