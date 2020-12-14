package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {

    private List<Event> events = new LinkedList<>();

    public List<Event> getEvents() {
        return events;
    }

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        // DONE : implémenter cette méthode
        this.events.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) throws Exception {
        if (this.events.isEmpty()) {
            throw new Exception("Aucun event enregisté !");
        }
        List<Event> allEventsInADay = new LinkedList<>();
        for (Event e : this.events) {
            if (e.isInDay(day)) {
                allEventsInADay.add(e);
            }
        }
        return allEventsInADay;
    }

    public List<Event> title(String title) throws Exception {
        if (this.events.isEmpty()) {
            throw new Exception("Aucun evenement n'est enregisté !");
        }
        List<Event> eventCorrectTitle = new LinkedList<>();
        for (Event e : this.events) {
            if (e.getMyTitle().equals(title)) {
                eventCorrectTitle.add(e);
            }
        }
        return eventCorrectTitle;
    }

    public boolean free(Event e) throws Exception {
        if (this.events.isEmpty()) {
            throw new Exception("Aucun evenement n'est enregisté !");
        }
        boolean boo = true;
        for (Event event : this.events) {
            if (e.isInDay(event.getMyStart().toLocalDate())) {
                if (e.getMyStart().toLocalTime().isBefore(event.getMyStart().toLocalTime()) || e.getMyStart().toLocalTime().equals(event.getMyStart().toLocalTime())) {
                    if (e.getMyStart().plus(e.getMyDuration()).toLocalTime().isAfter(event.getMyStart().toLocalTime()) || e.getMyStart().plus(e.getMyDuration()).toLocalTime().equals(event.getMyStart().toLocalTime())) {
                        boo = false;
                    }
                }
            }
        }
        return boo;
    }
}
