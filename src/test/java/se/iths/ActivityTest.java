package se.iths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.GregorianCalendar;

public class ActivityTest {

    @Test
    public void createActivity() {
        Activity activity = new Activity(1, 60, new GregorianCalendar(2024, 1, 1));

        assertEquals(1, activity.distance);
        assertEquals(60, activity.time.getSeconds());
        assertEquals(new GregorianCalendar(2024, 1, 1), activity.date);
    }

    @Test
    public void activityHasIdString() {
        Activity activity = new Activity(1, 60, new GregorianCalendar(2024, 1, 1));
        
        assertEquals("1", activity.id);

        Activity activity2 = new Activity(1, 60, new GregorianCalendar(2024, 1, 1));

        assertEquals("2", activity2.id);
    }
    
    @Test
    public void createActivityInHourMinuteSecond() {
        Activity activity = new Activity(1, 1, 2, 3, new GregorianCalendar(2024, 1, 1));

        assertEquals(3723, activity.time.getSeconds());
    }

    @Test
    public void calculateAverageSpeed() {
        Activity activity = new Activity(1, 1, 0, 0, new GregorianCalendar(2024, 1, 1));  

        assertEquals(1, activity.averageSpeed());
    }

    @Test
    public void canCalculatePace() {
        Activity activity = new Activity(1, 1, 0, 0, new GregorianCalendar(2024, 1, 1));  

        assertEquals(60, activity.calculatePace().toMinutes());

        Activity activity2 = new Activity(5, 0, 26, 30, new GregorianCalendar(2024, 1, 1));  

        assertEquals(318, activity2.calculatePace().getSeconds());
    }
}
