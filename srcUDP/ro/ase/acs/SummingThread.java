package ro.ase.acs;

public class SummingThread extends Thread{
    private int[] array;
    private int startIndex;
    private int endIndex;
    private long sum;

    public SummingThread(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
}
