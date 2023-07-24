import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Shop {
    private ArrayList<Toy> toys;

    public Shop(ArrayList<Toy> toys) {
        this.toys = toys;
    }

    public Toy setChance(ArrayList<Toy> toys) {
        int totalToys = toys.size();
        double chance = Math.random() * totalToys;
        int countWeight = 0;
        countWeight += toys.size();
        for (Toy toy : toys) {
            if (countWeight >= chance) return toy;
        }
        return null;
    }

    public Toy chooseOnCount(ArrayList<Toy> toys) {
        return null;
    }
    public void saveToyForLottery(ArrayList<Toy> toys) {
        ArrayList<Toy> toy = toys;
        String text = toy.toString();
        try (FileWriter writer = new FileWriter("Toys.txt", true)) {
            writer.write(text);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        toys.remove(toy);
    }
}
