package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import Process.Process;

public class Algorithm {
    ArrayList<Process> resultProcess = new ArrayList<>();
    LinkedList<Process> processQueue = new LinkedList<>();
    Random random = new Random();
    int totalWaitingTime = 0;
    int totalTurnaroundTime = 0;

    public void addToQueue(Process process){
        processQueue.addLast(process);
    }

    public void showData(Process process){
        System.out.println("AT: " + process.getArrivalTime());
        System.out.println("BT: " + process.getBurstTimeCopy());
        System.out.println("TAT: " + process.getTurnaroundTime());
        System.out.println("WT: " + process.getWaitingTime());
        System.out.println();
    }

    public void printCurrentQueue(){
        int i = 0;
        for(Process process:processQueue){
            System.out.println("Process nr: " + i++);
            System.out.println(process.getArrivalTime());
            System.out.println(process.getBurstTime());

        }
        System.out.println("----------------------------------------------------");
    }



}
