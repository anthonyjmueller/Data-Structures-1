/**
 * Created by Anthony on 10/7/2015.
 */
public class Teller {
    public int idolTime = 0;
    public int lastdepart = 0;

    /**
     * returns last depart
     * @return
     */
    public int getLastdepart() {
        return lastdepart;
    }

    /**
     * sets last depart
     * @param lastdepa
     */
    public void setLastdepart(int lastdepa) {
        lastdepart = lastdepa;
    }

    /**
     * returns idle time
     * @return
     */
    public int getIdolTime() {
        return idolTime;
    }

    /**
     * sets idle time
     * @param idolTime
     */
    public void setIdolTime(int idolTime) {
        idolTime = idolTime;
    }

    /**
     * adds idle time to current idle time
     * @param idol
     */
    public void addIdolTime(int idol){
        idolTime= idolTime + idol;
    }
}
