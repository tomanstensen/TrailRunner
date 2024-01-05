package se.iths;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.text.SimpleDateFormat;

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

    public Duration calculatePace() {
        double seconds = time.getSeconds() / distance;
        return Duration.ofSeconds((long) seconds);
    }

    @Override
    public String toString() {
        
        String returnString = "";
        returnString += "Distance: " + distance + "km\n";
        returnString += "Duration: " + time.toHoursPart() + " hour, " + time.toMinutesPart() + " minutes, " + time.toSecondsPart() + " seconds.\n";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        returnString += "Date: " + sdf.format(date.getTime()) + "\n";
        returnString += "Average speed: " + averageSpeed() + "km/h\n";
        returnString += "Pace: " + calculatePace().toMinutes() + ":" + calculatePace().toSecondsPart() + "min/km";
        return returnString;
    }
}
