import java.util.*;

/**
 * Created by Anthony Mueller on 10/7/2015.
 */
public class DataStructures1 {
    public DataStructures1() {

    }

    public static void main(String args[]) {

        int time = 0;
        int numtellers = 0;
        int arrmean = 0;
        int arrvar = 0;
        int servmean = 0;
        int servvar = 0;
        int timelimit = 0;
        int customerspro = 0;
        int customers = 1;
        int totalinterarr = 0;
        int totalserv = 0;
        int totalwait = 0;
        int maxwait = 0;
        int maxqueuelength = 1;
        Uniform nums = new Uniform();
        Random rad = new Random();
        int check = 500;
        boolean correct = true;

        do { // loop for inputs and test if inputs are correct
            correct = true;
            System.out.println("enter the number of tellers");
            Scanner scanman = new Scanner(System.in);
            if (scanman.hasNextInt())
                numtellers = scanman.nextInt();
            else {
                System.out.println("Incorrcet Input");
                correct = false;
            }

            System.out.println("input mean time followed by the variance for inter-arrival time");
            scanman = new Scanner(System.in);
            if (scanman.hasNextInt())
                arrmean = scanman.nextInt();
            else {
                System.out.println("Incorrcet Input");
                correct = false;
            }
            if (scanman.hasNextInt())
                arrvar = scanman.nextInt();
            else {
                System.out.println("Incorrcet Input");
                correct = false;
            }

            System.out.println("input mean time followed by the variance for service time");
            scanman = new Scanner(System.in);
            if (scanman.hasNextInt())
                servmean = scanman.nextInt();
            else {
                System.out.println("Incorrcet Input");
                correct = false;
            }
            if (scanman.hasNextInt())
                servvar = scanman.nextInt();
            else {
                System.out.println("Incorrcet Input");
                correct = false;
            }

            System.out.println("enter the time limit");
            scanman = new Scanner(System.in);
            if (scanman.hasNextInt())
                timelimit = scanman.nextInt();
            else {
                System.out.println("Incorrcet Input");
                correct = false;
            }
        } while (!(correct));

        PriorityQueue<Event> eventqueue = new PriorityQueue<Event>();
        eventqueue.add(new Event(nums.uniform(arrmean, arrvar, rad), nums.uniform(servmean, servvar, rad), -1));
        Teller[] tellers = new Teller[numtellers];
        for (int z = 0; z < numtellers; z++)
            tellers[z] = new Teller();
        Queue<Event>[] tellersq = new Queue[numtellers];
        for (int y = 0; y < numtellers; y++)
            tellersq[y] = new LinkedList<Event>();

        while (time < timelimit) { // processing loop
            if (time / check == 1){ // snapshot print
                nums.outputsnapshot(tellersq, eventqueue, time);
                check += 500;
            }

            time = eventqueue.peek().getAction();
            while (eventqueue.peek().getAction() == time) { // checks for multile events at the same time
                if (eventqueue.peek().getType() == -1) { // new customer case
                    int shortline = 0;
                    for (int x = 0; x < numtellers; x++) {// find shortest teller line
                        if (tellersq[x].isEmpty()){
                            shortline = x;
                            x = numtellers +1;
                        }
                        else if (tellersq[shortline].size() > tellersq[x].size()) { // tests for maxqueue length
                            shortline = x;
                            if (tellersq[shortline].size() > maxqueuelength)
                                maxqueuelength = tellersq[shortline].size();
                        }
                    }
                    if (tellersq[shortline].isEmpty()) { // if teller queue is empty
                        tellers[shortline].addIdolTime((time - tellers[shortline].getLastdepart()));
                        tellersq[shortline].add(eventqueue.peek());
                        Event temp = eventqueue.poll();
                        temp.setType(shortline);
                        temp.setAction((time + temp.getTimeService()));
                        eventqueue.add(temp);
                    }
                    else {  // adds to teller queue if queue is busy
                        eventqueue.peek().setType(shortline);
                        tellersq[shortline].add(eventqueue.poll());
                    }// adds new arrival event to queue
                    int temparr = nums.uniform(arrmean, arrvar, rad);
                    totalinterarr += temparr;
                    int tempser = nums.uniform(servmean, servvar, rad);
                    totalserv += tempser;
                    eventqueue.add(new Event(( temparr+ time),tempser, -1));
                    customers++;
                }
                else { // non arrival events
                    int eventTell = eventqueue.peek().getType();
                    int tempwait =  (time - eventqueue.peek().getTimeArrive());
                    if (tempwait > maxwait) // test to see if max wait time was just endured
                        maxwait = tempwait;
                    totalwait += tempwait;
                    tellersq[eventTell].poll();
                    customerspro++;
                    if (tellersq[eventTell].isEmpty()) { // if the teller queue is empty after removal
                        tellers[eventTell].setLastdepart(time);
                        eventqueue.poll();
                    } else { // if teller has more customers in queue
                        eventqueue.poll();
                        tellersq[eventTell].peek().setAction((time + tellersq[eventTell].peek().getTimeService()));
                        tellersq[eventTell].peek().setType(eventTell);
                        eventqueue.add(tellersq[eventTell].peek());
                    }
                }
            }
        }
        nums.outputfinal(customerspro, customers, totalinterarr, totalserv, totalwait,
                maxwait, maxqueuelength, time, tellers, tellersq);
    }
}
