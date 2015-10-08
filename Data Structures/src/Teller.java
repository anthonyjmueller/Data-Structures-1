/**
 * Created by Anthony on 10/7/2015.
 */
public class Teller {
    public int idolTime = 0;
    public int queue;
    public int lastdepart = 0;

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public int getQueue() {
        return queue;
    }

    public int getLastdepart() {
        return lastdepart;
    }

    public void setLastdepart(int lastdepart) {
        this.lastdepart = lastdepart;
    }

    public int getIdolTime() {
        return idolTime;
    }

    public void setIdolTime(int idolTime) {
        this.idolTime = idolTime;
    }

    public void addIdolTime(int idol){
        this.idolTime= this.idolTime + idol;
    }
}
