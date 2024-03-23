import CPU.CPU;

public class Main {
    public static void main(String[] args) {
        CPU cpu1 = new CPU(5000,0.2);
        cpu1.modeRoundRobin(3);
    }
}