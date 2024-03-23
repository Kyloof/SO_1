package Algorithms;

import Process.Process;
import Process.ProcessGenerator;
import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin extends Algorithm {

    private int quantum;

    public RoundRobin() {
    }

    public void simulateRoundRobin(int quantum, int currentTime, double generationChance, int STARVATION_TIME) {
        int avgWaitingTime = 0;
        int avgTurnaroundTime = 0;
        int starvedProcesses = 0;
        int maxStarvation=0;
        boolean addedTime=true;


        processQueue.add(ProcessGenerator.generateRandomProcess(currentTime));
        while (resultProcess.size()<=10000) {
            if(addedTime) {
                currentTime++;
                if (generationChance >= random.nextDouble()) {
                    int processAmount = random.nextInt(3);
                    for (int j = 0; j < processAmount; j++) {
                        addToQueue(ProcessGenerator.generateRandomProcess(currentTime));
                    }
                }
            }
            addedTime=true;
            if (!processQueue.isEmpty()) {
                addedTime = false;
                Process currentProcess = processQueue.getFirst();
                // Execute process for a quantum or until it finishes
                for (int i = 0; i < quantum && currentProcess.getBurstTime() > 0 && !processQueue.isEmpty(); i++) {
                    currentTime++;
                    if (generationChance >= random.nextDouble()) {
                        int processAmount = random.nextInt(3);
                        for (int j = 0; j < processAmount; j++) {
                            addToQueue(ProcessGenerator.generateRandomProcess(currentTime));
                        }
                    }
                    currentProcess.setBurstTime(currentProcess.getBurstTime() - 1);
                    // Check if new processes are generated
                    if (currentProcess.getBurstTime() == 0) {
                        processQueue.removeFirst();
                        currentProcess.setTurnaroundTime(currentTime - currentProcess.getArrivalTime());
                        avgTurnaroundTime += currentProcess.getTurnaroundTime();
                        currentProcess.setWaitingTime(currentProcess.getTurnaroundTime() - currentProcess.getBurstTimeCopy());
                        avgWaitingTime += currentProcess.getWaitingTime();
                        if (currentProcess.getWaitingTime() > STARVATION_TIME) starvedProcesses++;
                        if (currentProcess.getWaitingTime()>maxStarvation) maxStarvation++;

                        System.out.println("Process NO: " + resultProcess.size());
                        showData(currentProcess);
                        resultProcess.add(currentProcess);
                        if (!processQueue.isEmpty()) currentProcess = processQueue.getFirst();
                    }

                }
                if (currentProcess.getBurstTime() > 0){
                    processQueue.removeFirst();
                    addToQueue(currentProcess);
                }
            }
        }

        System.out.println("Average WT: " + avgWaitingTime / resultProcess.size());
        System.out.println("Average TAT: " + avgTurnaroundTime / resultProcess.size());
        System.out.println("Starved processes: " + starvedProcesses);
        System.out.println("Max Starvation: " + maxStarvation);

    }
}
