package Sorts;

import Process.Process;
import java.util.Comparator;

public class burstSort implements Comparator<Process> {
    @Override
    public int compare(Process p1, Process p2) {
        return p1.getBurstTimeCopy() - p2.getBurstTimeCopy();
    }
}