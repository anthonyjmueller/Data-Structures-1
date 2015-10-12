import java.util.Comparator;

/**
 * Created by Anthony on 10/7/2015.
 */
public class Event implements Comparable<Event> {
    public int timeArrive;
    public int timeService;
    public int type;
    public int action;

    /**
     * returns action
     * @return
     */
    public int getAction() {
        return action;
    }

    /**
     * sets action
     * @param action
     */
    public void setAction(int action) {
        this.action = action;
    }

    /**
     * returns type
     * @return
     */
    public int getType() {
        return type;
    }

    /**
     * sets type
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * retuns service time
     * @return
     */
    public int getTimeService() {
        return timeService;
    }

    /**
     * sets service time
     * @param timeService
     */
    public void setTimeService(int timeService) {
        this.timeService = timeService;
    }

    /**
     * returns arrival time
     * @return
     */
    public int getTimeArrive() {
        return timeArrive;
    }

    /**
     * sets arrival time
     * @param timeArrive
     */
    public void setTimeArrive(int timeArrive) {
        this.timeArrive = timeArrive;
    }

    /**
     * creates new event
     * @param timear
     * @param timeSer
     * @param type
     */
    Event(int timear, int timeSer, int type) { // for event queue
        setTimeArrive(timear);
        setTimeService(timeSer);
        setType(type);
        setAction(timear);
    }

    /**
     * sotrs the events within the event queue
     * @param o
     * @return
     */
    @Override
    public int compareTo(Event o) {
        if (this.getAction() > o.getAction())
            return 1;
        else if (this.getAction() == o.getAction())
            return 0;
        else
            return -1;
    }
}
