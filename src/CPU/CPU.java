package CPU;
import Algorithms.FCFS;
import Algorithms.RoundRobin;
import Algorithms.SJF;
import Process.*;

import java.util.Random;

public class CPU {
    private SJF sjf;
    private FCFS fcfs;
    private RoundRobin roundRobin;

    private int currentTime;
    private int STARVATION_TIME;
    private double GENERATION_CHANCE;
    public CPU(int STARVATION_TIME, double GENERATION_CHANCE){
        this.sjf = new SJF();
        this.fcfs = new FCFS();
        this.roundRobin = new RoundRobin();
        this.currentTime = 0;
        this.STARVATION_TIME=STARVATION_TIME;
        this.GENERATION_CHANCE=GENERATION_CHANCE;

    }

    public void modeSJF(){
        sjf.simulateSJF(currentTime, GENERATION_CHANCE,STARVATION_TIME);
    }

    public void modeFCFS(){
        fcfs.simulateFCFS(currentTime,GENERATION_CHANCE, STARVATION_TIME);
    }

    public void modeRoundRobin(int quantum){
        roundRobin.simulateRoundRobin(quantum, currentTime, GENERATION_CHANCE,STARVATION_TIME);
    }





}
