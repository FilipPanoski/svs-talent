import java.time.LocalTime;

public class TimePeriodOverlap {

    LocalTime startDate;
    LocalTime endDate;

    public TimePeriodOverlap(LocalTime startDate, LocalTime endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean overlapsWith(LocalTime startDate, LocalTime endDate){
        if (startDate.getHour() < endDate.getHour() && this.endDate.getHour() > startDate.getHour())
            return true;

        return false;
    }
}
