import java.awt.*;
import java.util.*;

/**
 * Created by Anthony on 10/7/2015.
 */
public class Uniform {
    public int uniform(int mean, int variant, Random rand)
// JAVA FUNCTION THAT RETURNS A UNIFORMLY RANDOM
// INTEGER IN THE RANGE OF MEAN +- VARIANT
//  Be sure to import java.util.Random
//  Be sure to declare rand in the calling function as follows:
//  Random rand = new Random();
    {
        int small   = mean - variant;
        int range   = 2 * variant + 1;
        return    small + rand.nextInt(range);
    }

    /**
     * prints detailed state of program (intended for use at end)
     * @param numcustpro
     * @param numcust
     * @param avgarrival
     * @param avgservice
     * @param avgcustwait
     * @param maxcuswait
     * @param maxqueuelength
     * @param time
     * @param tellers
     * @param tellersq
     */

    public void outputfinal(int numcustpro, int numcust, double avgarrival, double avgservice,
                       double avgcustwait, int maxcuswait, int maxqueuelength, int time,
                       Teller[] tellers, Queue<Event>[] tellersq) {
        System.out.println("1. Total customers processed:   " + numcustpro);
        System.out.println("2. Average inter-arrival time:   " + (double)avgarrival/numcust);
        System.out.println("3. Average service time:   " + (double)avgservice/numcust);
        System.out.println("4. Average wait time:   " + (double)avgcustwait/numcustpro);
        for (int x = 0; x < tellers.length; x++) {
            System.out.println("5. Percent idol time for cashier " + x + " is:   " +
                    (double)tellers[x].getIdolTime()/time *100
            + "%");
        }
        System.out.println("6. Max customer wait time is:   " + maxcuswait);
        System.out.println("7. Max queue length is:   " + maxqueuelength);
        int custremain = 0;
        for( int y = 0; y < tellersq.length; y++){
            custremain += tellersq[y].size();
        }
        System.out.println("8. total customers remaining in queues is:   " + custremain);
    }

    /**
     * prints a snapshot of the program (intended for use at 500 intervals)
     * @param tellersq
     * @param eventqueue
     * @param time
     */
    public void outputsnapshot(Queue<Event> []tellersq, PriorityQueue<Event> eventqueue, int time){
        System.out.println("The time is:  " + time);
        System.out.println("the event queue length is:   " + eventqueue.size());
        for( int y = 0; y < tellersq.length; y++){
            System.out.println("the number of people in queue :  " + y + " is:  " + tellersq[y].size());
        }
        System.out.println();
    }
}
