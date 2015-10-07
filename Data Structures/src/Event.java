/**
 * Created by Anthony on 10/7/2015.
 */
public class Event {
    public int timeArrive;
    public int timeService;
    public int type;

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

    Event(int timear,int timeSer, int type){
        setTimeArrive(timear);
        setTimeService(timeSer);
        setType(type);
    }
}
