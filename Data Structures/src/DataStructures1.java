import java.util.*;

/**
 * Created by Anthony on 10/7/2015.
 */
public class DataStructures1 {
    public DataStructures1(){

    }
    public static void main(String args[]){

        int time = 0;
        int numtellers=0;
        int arrmean=0;
        int arrvar=0;
        int servmean=0;
        int servvar=0;
        int timelimit=0;
        int customers = 0;
        Uniform nums = new Uniform();
        Random rad = new Random();
        inputs(numtellers, arrmean, arrvar, servmean, servvar, timelimit);
        Comparator<Event> comparer = new Event(nums.uniform(arrmean, arrvar, rad), nums.uniform(servmean, servvar, rad), -1);
        PriorityQueue<Event> eventqueue= new PriorityQueue(100, comparer);
        eventqueue.add(new Event(nums.uniform(arrmean, arrvar, rad), nums.uniform(servmean, servvar, rad), -1));
        Teller[] tellers = new Teller[numtellers];
        Queue<Event>[] tellersq = new Queue[numtellers];
        while (time < timelimit){
            time = eventqueue.peek().getAction();
            while (eventqueue.peek().getAction() == time){
                if (eventqueue.peek().getType() == -1) { // new customer case
                    int shortline = 0;
                    for (int x = 0; x <= tellers.length - 1; x++) { // find shortest teller line
                        if (tellersq[shortline].size() < tellersq[x].size())
                            shortline = x;
                    }
                    if (tellersq[shortline].isEmpty()) { // if teller queue is empty
                        tellers[shortline].addIdolTime((time - tellers[shortline].getLastdepart()));
                        tellersq[shortline].add(eventqueue.peek());
                        eventqueue.peek().setType(shortline);
                        eventqueue.peek().setAction((time + eventqueue.peek().getTimeService()));
                    }
                    else {
                        eventqueue.peek().setType(shortline);
                        tellersq[shortline].add(eventqueue.poll());
                    }
                    eventqueue.add(new Event(nums.uniform(arrmean, arrvar, rad), nums.uniform(servmean, servvar, rad), -1));
                }
                int eventTell = eventqueue.peek().getType(); // non arrival events
                tellersq[eventTell].poll();
                customers++;
                if (tellersq[eventTell].isEmpty()){
                    tellers[eventTell].setLastdepart(time);
                }
                else {
                    tellersq[eventTell].peek().setAction((time + tellersq[eventTell].peek().getTimeService()));
                    eventqueue.add(tellersq[eventTell].peek());
                }

            }
        }


    }



    public static void inputs(int numtellers, int arrmean, int arrvar, int servmean, int servvar, int timelimit){
        System.out.println("enter the number of tellers");
        Scanner scanman= new Scanner(System.in);
        if(scanman.hasNextInt())
            numtellers = scanman.nextInt();
        else {
            System.out.println("Incorrcet Input");
            inputs(numtellers,arrmean, arrvar, servmean, servvar, timelimit);
        }

        System.out.println("input mean time and variance for inter-arrival time");
        scanman= new Scanner(System.in);
        if(scanman.hasNextInt())
            arrmean = scanman.nextInt();
        else {
            System.out.println("Incorrcet Input");
            inputs(numtellers,arrmean, arrvar, servmean, servvar, timelimit);
        }
        if(scanman.hasNextInt())
            arrvar = scanman.nextInt();
        else {
            System.out.println("Incorrcet Input");
            inputs(numtellers,arrmean, arrvar, servmean, servvar, timelimit);
        }

        System.out.println("input mean time and variance for service time");
        scanman= new Scanner(System.in);
        if(scanman.hasNextInt())
            servmean = scanman.nextInt();
        else {
            System.out.println("Incorrcet Input");
            inputs(numtellers,arrmean, arrvar, servmean, servvar, timelimit);
        }
        if(scanman.hasNextInt())
            servvar = scanman.nextInt();
        else {
            System.out.println("Incorrcet Input");
            inputs(numtellers,arrmean, arrvar, servmean, servvar, timelimit);
        }

        System.out.println("enter the time limit");
        scanman= new Scanner(System.in);
        if(scanman.hasNextInt())
            timelimit = scanman.nextInt();
        else {
            System.out.println("Incorrcet Input");
            inputs(numtellers,arrmean, arrvar, servmean, servvar, timelimit);
        }


    }

}
