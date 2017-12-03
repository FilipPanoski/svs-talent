package alarms;

public class SystemAlarm implements Alarm {

    public void triggerAlarm(){
        System.out.println("Alarm!");
    }
}
