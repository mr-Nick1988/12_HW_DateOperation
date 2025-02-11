package telran.date.test;

import org.junit.jupiter.api.Test;
import telran.date.utils.DateOperation;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DateOperationTest {
    public static void main(String[] args) {
        System.out.println("Years from 12/04/1961: " + DateOperation.getAge("12/04/1961"));
        System.out.println("Years from 1961-01-12: " + DateOperation.getAge("1961-01-12"));
        String[] dates={"2000-12-01","10/12/2000","1970-08-12","2010-10-05"};
        String[] sortedDates = DateOperation.sortStringDates(dates);
        System.out.println("Sorted dates: "+ Arrays.toString(sortedDates));
    }

    @Test
    void testGetAge(){
        assertEquals(63, DateOperation.getAge("12/04/1961"));
        assertEquals(64,DateOperation.getAge("1961-01-12"));

    }

    @Test
    void testSortStringDates(){
        String[] dates = {"2000-12-01","10/12/2000","1970-08-12","2010-10-05"};
        String[] actual = DateOperation.sortStringDates(dates);
        String [] expected ={"1970-08-12","2000-12-01","10/12/2000","2010-10-05"};
        assertArrayEquals(expected,actual);
    }
}
