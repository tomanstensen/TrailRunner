package se.iths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import java.util.*;

public class ActivityManagerTest {
    
    ActivityManager activityManager;
    Activity shortDistanceActivity;
    Activity longDistanceActivity;
    Activity sameIdActivity;
    
    @Mock
    DatabaseAPI api;

    @BeforeEach
    public void setupActivityManager() {
        api = Mockito.mock(DatabaseAPI.class);
        activityManager = new ActivityManager(api);
        shortDistanceActivity = new Activity("1", 1, 60, new GregorianCalendar(2024, 1, 1));
        longDistanceActivity = new Activity("2", 4, 60, new GregorianCalendar(2024, 1, 1));
        sameIdActivity = new Activity("1", 1, 1, 0, 0, new GregorianCalendar(2024, 0, 1));
       
        activityManager.addActivity(shortDistanceActivity);
        activityManager.addActivity(longDistanceActivity);
    }

    @Test
    public void canGetActivityIDsFromDatabase() {
        List<String> activities = new ArrayList<>();
        activities.add("1");
        activities.add("2");
        
        when(api.getRecordIDs()).thenReturn(activities);

        assertEquals(2, activityManager.getIDs().size());
    }
    
    @Test
    public void testCreateActivityManager() {
        assertEquals(2, activityManager.activities.size());
    }

    @Test
    public void canAddActivityToMap() {
        assertEquals(2, activityManager.activities.size());
    }

    @Test
    public void canGetActivityFromMap() {
        String activityId = shortDistanceActivity.id;
        Activity retrievedActivity = activityManager.getActivity(activityId);
        assertEquals(shortDistanceActivity.id, retrievedActivity.id);
        assertEquals(shortDistanceActivity.distance, retrievedActivity.distance);
        assertEquals(shortDistanceActivity.time, retrievedActivity.time);
        assertEquals(shortDistanceActivity.date, retrievedActivity.date);
    }

    @Test
    public void canCalculateTotalDistance() {       
        assertEquals(5.0, activityManager.totalDistance());
    }

    @Test
    public void canCalculateAverageDistance() {
        assertEquals(2.5, activityManager.averageDistance());
    }

    @Test
    public void canRemoveActivity() {
        assertEquals(2, activityManager.activities.size());

        activityManager.removeActivity(longDistanceActivity.id);

        assertEquals(1, activityManager.activities.size());
    }

    @Test
    public void canGetNextActivityId() {
        activityManager = new ActivityManager();
        
        assertEquals("1", activityManager.getNextActivityId());
        assertEquals("2", activityManager.getNextActivityId());
    }

    @Test
    public void canAutogenerateId() {
        Activity firstIdActivity = new Activity(activityManager.getNextActivityId(), 1, 1, 0, 0, new GregorianCalendar(2024, 0, 1));
        Activity nextIdActivity = new Activity(activityManager.getNextActivityId(), 1, 1, 0, 0, new GregorianCalendar(2024, 0, 1));

        assertEquals("1", firstIdActivity.id);
        assertEquals("2", nextIdActivity.id);
    }

    @Test
    public void canNotHaveSameId() {
        assertThrows(IllegalArgumentException.class, () -> activityManager.addActivity(sameIdActivity));
    }
}
