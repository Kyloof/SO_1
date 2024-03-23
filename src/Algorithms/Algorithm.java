package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {
    LinkedList<Process> processQueues = new LinkedList<>();
    int totalWaitingTime = 0;
    int totalTurnaroundTime = 0;

    public void addToQueue(Process process){
        processQueues.addLast(process);
    }
}
