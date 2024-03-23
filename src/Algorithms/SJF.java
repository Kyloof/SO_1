package Algorithms;

import Sorts.arrivalSort;
import Process.Process;
import Sorts.burstSort;
import Process.ProcessGenerator;

import java.util.ArrayList;

public class SJF extends Algorithm{

    public void sortListByBurstTime(){ processQueue.sort(new burstSort());}

    public void simulateSJF(int currentTime, double GENERATION_CHANCE, int STARVATION_TIME){
        boolean isFinished=false;
        int maxStarvation = 0;
        int starvedProcesses = 0;
        int avgWaitingTime=0;
        int avgTurnaroundTime=0;
        processQueue.add(ProcessGenerator.generateRandomProcess(currentTime));
        Process currentProcess = processQueue.getFirst();
        while (resultProcess.size()<=20000){
            if (GENERATION_CHANCE>=random.nextDouble() && processQueue.size()+resultProcess.size()<=20000) addToQueue(ProcessGenerator.generateRandomProcess(currentTime));
            if (isFinished && processQueue.size()>0){
                currentProcess = processQueue.getFirst();
                isFinished=false;
            }
            currentProcess.setBurstTime(currentProcess.getBurstTime()-1);


            currentTime++;
            if (currentProcess.getBurstTime()==0){

                processQueue.removeFirst();
                currentProcess.setTurnaroundTime(currentTime - currentProcess.getArrivalTime());
                avgTurnaroundTime+=currentProcess.getTurnaroundTime();
                currentProcess.setWaitingTime(currentProcess.getTurnaroundTime() - currentProcess.getBurstTimeCopy());
                avgWaitingTime+=currentProcess.getWaitingTime();
                if (currentProcess.getWaitingTime()>STARVATION_TIME) starvedProcesses+=1;
                if(currentProcess.getWaitingTime()>maxStarvation) maxStarvation= currentProcess.getWaitingTime();
                System.out.println("Process NO: " + resultProcess.size());
                showData(currentProcess);

                resultProcess.add(currentProcess);
                sortListByBurstTime();
                isFinished=true;
            }

        }


        System.out.println("Average WT: " + avgWaitingTime/ resultProcess.size());
        System.out.println("Average TAT: " + avgTurnaroundTime / resultProcess.size());
        System.out.println("Starved processes: " + starvedProcesses);
        System.out.println("Max Starvation: " + maxStarvation);

    }
}
