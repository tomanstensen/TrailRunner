package se.iths;
import java.util.*;

public class ActivityManager {
    Map<String, Activity> activities;
    DatabaseAPI api;
    public long idCounter = 1;

    public ActivityManager() {
        activities = new HashMap<>();
    }
    public ActivityManager(DatabaseAPI api) {
        this.api = api;
        activities = new HashMap<>();
    }

    public void addActivity(Activity activity) {
        if (activities.containsKey(activity.id)) {
            throw new IllegalArgumentException("ID already excist");
        }
        activities.put(activity.id, activity);
    }

    public Activity getActivity(String id) {
        return activities.get(id);
    }

    public List<String> getIDs() {
        return api.getRecordIDs();
    }
    
    public double totalDistance() {
        double totalDistance = 0;
        for(Activity activity : activities.values() ){
            totalDistance += activity.distance;
        }
        return totalDistance;
    }

    public double averageDistance() {
        int totalActivities = activities.size();
        return totalDistance() / totalActivities;
    }

    public void removeActivity(String id) {
        activities.remove(id);
    }

    public String getNextActivityId() {
        return Long.toString(idCounter++);
    }
}
