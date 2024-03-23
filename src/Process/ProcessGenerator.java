package Process;
import java.util.ArrayList;
import java.util.Random;
public class ProcessGenerator {
    private static Random random = new Random();

    public static Process generateRandomProcess(int arrivalTime){
        int burstTime = random.nextInt(15)+1;
        return new Process(burstTime,arrivalTime);
    }
}

