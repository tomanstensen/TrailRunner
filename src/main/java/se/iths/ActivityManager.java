package se.iths;
import java.util.Map;
import java.util.HashMap;

public class ActivityManager {
    Map<String, Activity> activities;

    public ActivityManager() {
        activities = new HashMap<>();
    }

    public void addActivity(Activity activity) {
        activities.put(activity.id, activity);
        
    }

    public Activity getActivity(String id) {
        return activities.get(id);
    }
    
}
