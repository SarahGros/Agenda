package agenda;

import java.time.*;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;

    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The durarion of the event
     */
    private Duration myDuration;

    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        if (this.myStart.getYear() != aDay.getYear() || !this.myStart.getMonth().equals(aDay.getMonth()) || this.myStart.getDayOfMonth() != aDay.getDayOfMonth()) {
            return false;
        } else {
            return true;
        }
    }

    // public boolean isInDay(LocalDate aDay) {
    //   LocalDateTime end = this.myStart.plus(this.myDuration);
    // if(aDay.isBefore((ChronoLocalDate)(ChronoLocalDateTime)end) && aDay.isAfter((ChronoLocalDate)(ChronoLocalDateTime)this.myStart)){
    //return true;
    //     }else{
    //   return false;
    //    }
    // }

    public String getMyTitle() {
        return myTitle;
    }

    public LocalDateTime getMyStart() {
        return myStart;
    }

    public Duration getMyDuration() {
        return myDuration;
    }
}
