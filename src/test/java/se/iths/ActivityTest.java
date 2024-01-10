package se.iths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.GregorianCalendar;

public class ActivityTest {
    Activity activityMadeWithSeconds;
    Activity activityMadeWithHMS;
    Activity activityWithExpectedPace1;
    Activity activityWithRealPace;

    @BeforeEach
    public void setupActivities() {
        activityMadeWithSeconds = new Activity("1", 1, 60, new GregorianCalendar(2024, 1, 1));
        activityMadeWithHMS = new Activity("2", 1, 1, 2, 3, new GregorianCalendar(2024, 1, 1));
        activityWithExpectedPace1 = new Activity("3", 1, 1, 0, 0, new GregorianCalendar(2024, 0, 1));  
        activityWithRealPace = new Activity("4", 5, 0, 26, 30, new GregorianCalendar(2024, 1, 1));  
    }

    @Test
    public void createActivity() {
        assertEquals(1, activityMadeWithSeconds.distance);
        assertEquals(60, activityMadeWithSeconds.time.getSeconds());
        assertEquals(new GregorianCalendar(2024, 1, 1), activityMadeWithSeconds.date);
    }

    @Test
    public void activityHasIdString() {
        assertEquals("1", activityMadeWithSeconds.id);
        assertEquals("2", activityMadeWithHMS.id);
    }
    
    @Test
    public void createActivityInHourMinuteSecond() {
        assertEquals(3723, activityMadeWithHMS.time.getSeconds());
        assertEquals(60, activityMadeWithSeconds.time.getSeconds());
    }

    @Test
    public void calculateAverageSpeed() {
        assertEquals(1, activityWithExpectedPace1.averageSpeed());
    }

    @Test
    public void canCalculatePace() {
        assertEquals(60, activityWithExpectedPace1.calculatePace().toMinutes());
        assertEquals(318, activityWithRealPace.calculatePace().getSeconds());
    }

    @Test
    public void canGetDetailsFromToString() {
        String[] actualStrings = activityWithExpectedPace1.toString().split("\n");
        assertEquals("Distance: 1.0km", actualStrings[0]);
        assertEquals("Duration: 1 hour, 0 minutes, 0 seconds.", actualStrings[1]);
        assertEquals("Date: 2024-01-01", actualStrings[2]);
        assertEquals("Average speed: 1.0km/h", actualStrings[3]);
        assertEquals("Pace: 60:0min/km", actualStrings[4]);
    }

    @Test
    public void canCreateActivityWithId() {
        assertEquals("1", activityMadeWithSeconds.id);
        assertEquals("2", activityMadeWithHMS.id);
    }
    
}
