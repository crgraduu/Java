package ro.ase.acs;

public class Main {
    public static void main(String[] args) {
        int[] values = new int[200_000_000];
        for (int i = 0; i < 200_000_000; i++) {
            values[i] = i + 1;
        }
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < values.length; i++)
            sum=sum+ values[i];
        long endTime = System.currentTimeMillis();
        System.out.println("Single Thread Sum="+sum+ "Computed In=" +(endTime-startTime));

        final int NB_OF_THREADS = 4;
        
        SummingThread[] threads = new SummingThread[NB_OF_THREADS];
        for (int i = 0; i < NB_OF_THREADS; i++) {
            threads[i]= new SummingThread(values, values.length / NB_OF_THREADS*i, values.length / NB_OF_THREADS*(i + 1));
        }
    }
}