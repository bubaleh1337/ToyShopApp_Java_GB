public abstract class Toy {
    int id, amount;
    String name;
    public Toy(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Toy: №%d. %s - %d q.", id, name, amount);
    }
}
