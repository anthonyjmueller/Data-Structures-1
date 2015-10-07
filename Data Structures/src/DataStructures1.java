import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Anthony on 10/7/2015.
 */
public class DataStructures1 {
    public DataStructures1(){

    }
    public static void main(String args[]){
        PriorityQueue eventqueue= new PriorityQueue(100);
        int time = 0;
        int numtellers=0;
        int arrmean=0;
        int arrvar=0;
        int servmean=0;
        int servvar=0;
        int timelimit=0;
        Uniform nums = new Uniform();
        Random rad = new Random();

        inputs(numtellers, arrmean, arrvar, servmean, servvar, timelimit);

        eventqueue.add(new Event(nums.uniform(arrmean, arrvar, rad), nums.uniform(servmean, servvar, rad), -1));


        while (time < timelimit){

        }


    }



    public static void inputs(int numtellers, int arrmean, int arrvar, int servmean, int servvar, int timelimit){
        System.out.println("enter the number of tellers");
        Scanner scanman= new Scanner(System.in);
        if(scanman.hasNextInt() && scanman.nextInt() >= 0)
            numtellers = scanman.nextInt();
        else {
            System.out.println("Incorrcet Input");
            inputs(numtellers,arrmean, arrvar, servmean, servvar, timelimit);
        }

        System.out.println("input mean time and variance for inter-arrival time");
        scanman= new Scanner(System.in);
        if(scanman.hasNextInt() && scanman.nextInt() >= 0)
            arrmean = scanman.nextInt();
        else {
            System.out.println("Incorrcet Input");
            inputs(numtellers,arrmean, arrvar, servmean, servvar, timelimit);
        }
        if(scanman.hasNextInt() && scanman.nextInt() >= 0)
            arrvar = scanman.nextInt();
        else {
            System.out.println("Incorrcet Input");
            inputs(numtellers,arrmean, arrvar, servmean, servvar, timelimit);
        }

        System.out.println("input mean time and variance for servoce time");
        scanman= new Scanner(System.in);
        if(scanman.hasNextInt() && scanman.nextInt() >= 0)
            servmean = scanman.nextInt();
        else {
            System.out.println("Incorrcet Input");
            inputs(numtellers,arrmean, arrvar, servmean, servvar, timelimit);
        }
        if(scanman.hasNextInt() && scanman.nextInt() >= 0)
            servvar = scanman.nextInt();
        else {
            System.out.println("Incorrcet Input");
            inputs(numtellers,arrmean, arrvar, servmean, servvar, timelimit);
        }

        System.out.println("enter the time limit");
        scanman= new Scanner(System.in);
        if(scanman.hasNextInt() && scanman.nextInt() >= 0)
            timelimit = scanman.nextInt();
        else {
            System.out.println("Incorrcet Input");
            inputs(numtellers,arrmean, arrvar, servmean, servvar, timelimit);
        }


    }

}
