import java.util.Comparator;

/**
 * Created by Anthony on 10/7/2015.
 */
public class Event implements Comparator <Event> {
    public int timeArrive;
    public int timeService;
    public int type;
    public int action;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTimeService() {
        return timeService;
    }

    public void setTimeService(int timeService) {
        this.timeService = timeService;
    }

    public int getTimeArrive() {
        return timeArrive;
    }

    public void setTimeArrive(int timeArrive) {
        this.timeArrive = timeArrive;
    }

    Event(int timear, int timeSer, int type) { // for event queue
        setTimeArrive(timear);
        setTimeService(timeSer);
        setType(type);
    }

    //Event(int timarr, int )

    public int compare(Event o1, Event o2) {
        if (o1.getAction() < o2.getAction())
            return o1.getAction();
        else
            return o2.getAction();
    }
}
