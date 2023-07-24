public abstract class Toy {
    int id, amount;
    String name;
    double weight;
    int price;
    public Toy(int id, String name, int amount, double weight, int price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.weight = weight;
        this.price = price;
    }
    @Override
    public String toString() {
        return String.format("Toy: №%d. %s - %d q. - %s$", id, name, amount, price);
    }
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }
    public int getPrice() {
        return price;
    }
}
