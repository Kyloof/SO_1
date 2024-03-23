package Process;

public class Process{
    private int burstTimeCopy;
    private int burstTime;
    private int arrivalTime;
    private int waitingTime = 0;
    private int turnaroundTime = 0;

    public Process(int burstTime,int arrivalTime) {
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.burstTimeCopy=burstTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public int getBurstTimeCopy() {
        return burstTimeCopy;
    }
}
