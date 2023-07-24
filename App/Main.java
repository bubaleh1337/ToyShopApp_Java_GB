import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Toy> toys = new ArrayList<>();
        int toysCount = 30;
        Random rand = new Random();
        for (int i = 0; i < toysCount; i++) {
            int val = rand.nextInt(7);
            addRandomToys(val, i, toys);
        }
    }
    public static void addRandomToys(int val, int i, ArrayList<Toy> toys) {
        Random rand = new Random();
        switch (i) {
            case 0 -> toys.add(new Rabbit(val));
            case 1 -> toys.add(new Kitty(val));
        }
    }
}
