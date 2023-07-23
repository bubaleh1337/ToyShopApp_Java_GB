import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Shop {
    private ArrayList<Toy> toys;
    public Shop(ArrayList<Toy> toys) {
        this.toys = toys;
    }
    public Toy setWeight(ArrayList<Toy> toys) {
        int weight = 0, countWeight = 0;
        for (Toy toy:toys) {
            weight += toy.getAmount();
        }
        double average = Math.random() * weight;
        for (Toy toy:toys) {
            countWeight += toy.getAmount();
            if (countWeight >= average) return toy;
        }
        return null;
    }
    public Toy chooseOnCount(ArrayList<Toy> toys) {
        return null;
    }
    public Toy getPrice(){
        Random rand = new Random();
        Toy toy = rand(chooseOnCount(toys));
    }
    public void saveToyForLottery() {
        Toy toy = getPrice();
        String text = toy.toString();
        try(FileWriter writer = new FileWriter("Toys.txt", true))
        {
            writer.write(text);
            writer.append('\n');
            writer.flush();
        }
        catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        toys.remove(toy);
    }
}
