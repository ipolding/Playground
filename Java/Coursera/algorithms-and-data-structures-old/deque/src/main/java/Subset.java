import edu.princeton.cs.algs4.StdIn;

public class Subset {

    public static void main(String[] args) {

        //takes a command-line integer k
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue();
        //reads in a sequence of N strings from using StdIn.readString();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            randomizedQueue.enqueue(item);
        }
        //prints out exactly k of them, uniformly at random
        for (int i = 0; i < k; k++) {
            System.out.println(randomizedQueue.dequeue());
        }

    }
}