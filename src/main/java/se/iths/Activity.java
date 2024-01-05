package se.iths;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Activity {
    public static long idCounter = 1;
    double distance;
    Duration time;
    Calendar date;
    String id;

    public Activity(double distance, int time, Calendar date){
        this.distance = distance;
        this.time = Duration.ofSeconds(time);
        this.date = date; 
        this.id = Long.toString(idCounter++);
    }

    public Activity(double distance, int hours, int minutes, int seconds, Calendar date){
        Duration tempTime = Duration.ofHours(hours);
        tempTime = tempTime.plusMinutes(minutes);
        tempTime = tempTime.plusSeconds(seconds);
        this.distance = distance;
        this.time = tempTime;
        this.date = date; 
        this.id = Long.toString(idCounter++);
    }

    public double averageSpeed() {
        return distance/(time.toHours());
    }
}
