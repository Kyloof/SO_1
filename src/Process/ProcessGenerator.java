package Process;
import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;
public class ProcessGenerator {
    private static Random random = new Random();

    public static Process generateRandomProcess(){
        int burstTime = random.nextInt(1,3)+1;
        int arrivalTime = random.nextInt(1,3)+1;

        return new Process(burstTime,arrivalTime);
    }

    public static ArrayList<Process> generateProcessList(int size){
        ArrayList<Process> newProcessList = new ArrayList<Process>();
        for (int i = 0; i<size;i++){
            newProcessList.add(generateRandomProcess());
        }
        return newProcessList;
    }
}

