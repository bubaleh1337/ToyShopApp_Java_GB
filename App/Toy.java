public class Toy implements Lotable {
    int id;
    String name;
    public Toy(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Игрушка №" + id + ". " + name;
    }
}
